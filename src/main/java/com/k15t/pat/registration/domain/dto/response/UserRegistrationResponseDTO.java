package com.k15t.pat.registration.domain.dto.response;

import com.k15t.pat.registration.domain.BaseResponseDTO;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

/**
 * Created by MAP2LE on 29.04.2018.
 */
public class UserRegistrationResponseDTO extends BaseResponseDTO{

    private String name;
    private String email;
    private String phoneNumber;
    private String country;
    private String city;
    private String street;
    private String zipCode;
    private Short houseNumber;

}
