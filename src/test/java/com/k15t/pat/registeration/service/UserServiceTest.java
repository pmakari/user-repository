package com.k15t.pat.registeration.service;

import com.k15t.pat.registeration.BaseTest;
import com.k15t.pat.registration.domain.dto.UserRegistrationDTO;
import com.k15t.pat.registration.domain.entity.UserEntity;
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
        UserRegistrationDTO userRegistrationDTO = new UserRegistrationDTO();
        userRegistrationDTO.setName("parviz");
        userRegistrationDTO.setEmail("parvizmakarti@gmail.com");
        userRegistrationDTO.setPassword("mm900");
        userRegistrationDTO.setPhoneNumber("+4917656883");
        userRegistrationDTO.setAddress(new UserEntity.Address("Germany", "Stuttgart", "Allmandring", "70569", (short) 35));
        //act
        UserRegistrationDTO expectedEntity = userService.save(userRegistrationDTO);
        //asserts
        Assert.assertNotEquals(expectedEntity, null);
        Assert.assertEquals(expectedEntity.getName(), userRegistrationDTO.getName());
        Assert.assertNotNull(expectedEntity.getId());
    }
}
