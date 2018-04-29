package com.k15t.pat.registration.domain.dto;

import com.k15t.pat.registration.domain.entity.UserEntity;
import lombok.*;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;

/**
 * Created by Parviz on 29.04.2018.
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserRegistrationDTO {

    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String password;

    @NotBlank
    @Email
    private String email;

    @Pattern(regexp = "^[+]{0,1}[0-9]{5,32}$")
    private String phoneNumber;

    private UserEntity.Address address;
}
