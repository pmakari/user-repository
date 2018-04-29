package com.k15t.pat.registration.service;

import com.k15t.pat.registration.domain.dto.request.UserRegistrationRequestDTO;

/**
 * Created by Parviz on 29.04.2018.
 */
public interface UserService {

public UserRegistrationRequestDTO save(UserRegistrationRequestDTO registrationDTO);
}
