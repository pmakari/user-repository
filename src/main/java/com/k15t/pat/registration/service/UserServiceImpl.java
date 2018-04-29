package com.k15t.pat.registration.service;

import com.k15t.pat.registration.domain.dto.UserRegistrationDTO;
import com.k15t.pat.registration.domain.entity.UserEntity;
import com.k15t.pat.registration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        UserEntity userEntity =new UserEntity();
        userEntity.setName(registrationDTO.getName());
        userEntity.setEmail(registrationDTO.getEmail());
        userEntity.setPassword(registrationDTO.getPassword());
        userEntity.setPhoneNumber(registrationDTO.getPhoneNumber());
        UserEntity.Address address=new UserEntity.Address(registrationDTO.getAddress().getCountry()
                ,registrationDTO.getAddress().getCity(),registrationDTO.getAddress().getStreet(),registrationDTO.getAddress().getZipCode(),
                registrationDTO.getAddress().getHouseNumber());
        userEntity.setAddress(address);

        UserEntity storedUserEntity =userRepository.save(userEntity);
        UserRegistrationDTO userRegDTO=new UserRegistrationDTO();
            userRegDTO.setEmail(storedUserEntity.getEmail());
            userRegDTO.setName(storedUserEntity.getName());
            userRegDTO.setPhoneNumber(storedUserEntity.getPhoneNumber());
            userRegDTO.setAddress(storedUserEntity.getAddress());
            userRegDTO.setId(storedUserEntity.getId());
        return userRegDTO;
    }
}
