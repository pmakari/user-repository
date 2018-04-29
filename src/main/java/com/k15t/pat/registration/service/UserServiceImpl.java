package com.k15t.pat.registration.service;

import com.k15t.pat.registration.domain.dto.UserRegistrationDTO;
import com.k15t.pat.registration.domain.entity.UserEntity;
import com.k15t.pat.registration.exception.BusinessException;
import com.k15t.pat.registration.exception.specific.DuplicateUserException;
import com.k15t.pat.registration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Parviz on 29.04.2018.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserRegistrationDTO save(UserRegistrationDTO registrationDTO) {
        UserEntity userEntity = UserEntity.builder().name(registrationDTO.getName())
        .email(registrationDTO.getEmail()).password(registrationDTO.getPassword()).phoneNumber(registrationDTO.getPhoneNumber())
        .address(UserEntity.Address.builder().country(registrationDTO.getCountry())
                .city(registrationDTO.getCity()).street(registrationDTO.getStreet()).zipCode(registrationDTO.getZipCode())
                .houseNumber(registrationDTO.getHouseNumber()).build()).build();
        try {
            UserEntity storedUserEntity = userRepository.save(userEntity);
            return  UserRegistrationDTO.builder().email(storedUserEntity.getEmail()).name(storedUserEntity.getName())
            .phoneNumber(storedUserEntity.getPhoneNumber()).city(storedUserEntity.getAddress().getCity())
                    .country(storedUserEntity.getAddress().getCountry())
                    .street(storedUserEntity.getAddress().getStreet())
                    .zipCode(storedUserEntity.getAddress().getZipCode())
                    .houseNumber(storedUserEntity.getAddress().getHouseNumber()).build();
        }catch (DataIntegrityViolationException ex){
            throw new DuplicateUserException(ex.getMessage(),ex);
        }catch (DataAccessException ex){
            throw new BusinessException(ex.getMessage(),ex);
        }
    }
}
