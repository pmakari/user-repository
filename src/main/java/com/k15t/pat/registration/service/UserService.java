package com.k15t.pat.registration.service;

import com.k15t.pat.registration.domain.dto.request.UserRegistrationRequestDTO;
import com.k15t.pat.registration.domain.dto.response.UserRegistrationResponseDTO;

/**
 * Created by Parviz on 29.04.2018.
 */
public interface UserService {

public UserRegistrationResponseDTO save(UserRegistrationRequestDTO registrationDTO);
}
