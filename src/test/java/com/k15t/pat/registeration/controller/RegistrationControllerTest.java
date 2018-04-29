package com.k15t.pat.registeration.controller;

import com.k15t.pat.registeration.BaseTest;
import com.k15t.pat.registration.config.JacksonMapperConfig;
import com.k15t.pat.registration.domain.dto.request.UserRegistrationRequestDTO;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;

import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Parviz on 29.04.2018.
 */
public class RegistrationControllerTest extends BaseTest {


    @Before
    public void init() {
        jdbcTemplate.update("insert into users(id,created_at,version,name, password, email, phone_number,country,city,street,zip_code,house_number) " +
                        "values(?,?, ?, ?, ?, ?,?,?,?,?,?,?)",
                1, new Date(), 1l, "Parviz", "password", "parvizmakarti@gmail.com", "+4917678", "Germany", "Stuttgart", "Allmandring", "70569", (short) 3);
    }

    @Test
    public void post_registrationData_ok() throws Exception {
        //arrange
        UserRegistrationRequestDTO requestDTO = UserRegistrationRequestDTO.builder().name("parviz").email("parviz@gmail.com").password("mm900")
                .phoneNumber("+4917656883").country("Germany").city("Stuttgart").street("Allmandrin")
                        .zipCode("70569").houseNumber((short) 35).build();
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
        UserRegistrationRequestDTO requestDTO = UserRegistrationRequestDTO.builder().name("parviz")
                .email("wrongEmailPattern").password(null).city(null)
                .phoneNumber("+4917656883").build();
        //act and asserts
        mvc.perform(post("/register")
                .content(JacksonMapperConfig.getObjectMapper().writeValueAsString(requestDTO))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }


    @Test
    public void post_duplicateEmail_conflictCode() throws Exception {
        //arrange
        UserRegistrationRequestDTO requestDTO = UserRegistrationRequestDTO.builder().name("parviz").email("parvizmakarti@gmail.com").password("mm900")
                .phoneNumber("+4917656883").country("Germany").city("Stuttgart").street("Allmandrin")
                        .zipCode("70569").houseNumber((short) 35).build();
        //act and asserts
        mvc.perform(post("/register")
                .content(JacksonMapperConfig.getObjectMapper().writeValueAsString(requestDTO))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isConflict());
    }


}
