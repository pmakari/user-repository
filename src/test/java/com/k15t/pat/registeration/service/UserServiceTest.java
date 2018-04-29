package com.k15t.pat.registeration.service;

import com.k15t.pat.registeration.BaseTest;
import com.k15t.pat.registration.domain.dto.request.UserRegistrationRequestDTO;
import com.k15t.pat.registration.domain.dto.response.UserRegistrationResponseDTO;
import com.k15t.pat.registration.exception.specific.DuplicateUserException;
import com.k15t.pat.registration.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Parviz on 29.04.2018.
 */
public class UserServiceTest extends BaseTest {

    @Autowired
    private UserService userService;

    @Test
    public void save_registrationData_succeed() {
        //arrange
        UserRegistrationRequestDTO userRegistrationRequestDTO = UserRegistrationRequestDTO.builder().name("parviz").email("parvizmakarti@gmail.com").password("mm900")
                .phoneNumber("+4917656883").country("Germany").city("Stuttgart").street("Allmandrin")
                .zipCode("70569").houseNumber((short)35).build();
        //act
        UserRegistrationResponseDTO expectedEntity = userService.save(userRegistrationRequestDTO);
        //asserts
        Assert.assertNotEquals(expectedEntity, null);
        Assert.assertEquals(expectedEntity.getName(), userRegistrationRequestDTO.getName());
        Assert.assertNotNull(expectedEntity.getName());
    }

    @Test(expected = DuplicateUserException.class)
    public void save_duplicateUserEmail_throwException() {
        //arrange
        UserRegistrationRequestDTO userRegistrationRequestDTO = UserRegistrationRequestDTO.builder().name("parviz").email("parvizmakarti@gmail.com").password("mm900")
                .phoneNumber("+4917656883").country("Germany").city("Stuttgart").street("Allmandrin")
                        .zipCode("70569").houseNumber((short)35).build();
        //act
        userService.save(userRegistrationRequestDTO);
        userService.save(userRegistrationRequestDTO);
    }

}
