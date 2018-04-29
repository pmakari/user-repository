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
        UserRegistrationDTO requestDTO =UserRegistrationDTO.builder().name("parviz").email("parvizmakarti@gmail.com").password("mm900")
                .phoneNumber("+4917656883").address(UserEntity.Address.builder().country("Germany").city("Stuttgart").street("Allmandrin")
                        .zipCode("70569").houseNumber((short)35).build()).build();
        //act and asserts
        mvc.perform(post("/register")
                .content(JacksonMapperConfig.getObjectMapper().writeValueAsString(requestDTO))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    @Test
    public void post_wrongRegistrationData_badRequest() throws Exception {
        //arrange
        UserRegistrationDTO requestDTO =UserRegistrationDTO.builder().name("parviz")
                .email("wrongEmailPattern").password(null).address(null)
                .phoneNumber("+4917656883").build();
        //act and asserts
        mvc.perform(post("/register")
                .content(JacksonMapperConfig.getObjectMapper().writeValueAsString(requestDTO))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }


}
