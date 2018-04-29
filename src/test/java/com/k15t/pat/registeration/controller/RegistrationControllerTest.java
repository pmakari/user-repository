package com.k15t.pat.registeration.controller;

import com.k15t.pat.registeration.BaseTest;
import com.k15t.pat.registration.config.JacksonMapperConfig;
import com.k15t.pat.registration.domain.dto.UserRegistrationDTO;
import com.k15t.pat.registration.domain.entity.UserEntity;
import org.junit.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by MAP2LE on 29.04.2018.
 */
public class RegistrationControllerTest extends BaseTest{

    @Test
    public void post_registrationData_ok() throws Exception {
        //arrange
        UserRegistrationDTO requestDTO = new UserRegistrationDTO();
        requestDTO.setName("parviz");
        requestDTO.setEmail("parvizmakarti@gmail.com");
        requestDTO.setPassword("mm900");
        requestDTO.setPhoneNumber("+4917656883");
        requestDTO.setAddress(new UserEntity.Address("Germany", "Stuttgart", "Allmandring", "70569", (short) 35));
        //act and asserts
        mvc.perform(post("/register")
                .content(JacksonMapperConfig.getObjectMapper().writeValueAsString(requestDTO))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
