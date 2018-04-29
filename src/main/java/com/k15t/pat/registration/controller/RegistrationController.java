package com.k15t.pat.registration.controller;

import com.k15t.pat.registration.aspect.CheckBindingResult;
import com.k15t.pat.registration.domain.dto.UserRegistrationDTO;
import com.k15t.pat.registration.service.UserService;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.StringWriter;


@RestController
public class RegistrationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationController.class.getName());

    @Autowired
    private VelocityEngine velocityEngine;
    @Autowired
    UserService userService;


    @GetMapping("/registration.html")
    public String registration() {

        Template template = velocityEngine.getTemplate("templates/registration.vm");
        VelocityContext context = new VelocityContext();
        StringWriter writer = new StringWriter();
        template.merge(context, writer);

        return writer.toString();
    }
    @CheckBindingResult
    @PostMapping("/register")
    public UserRegistrationDTO register(@RequestBody @Validated UserRegistrationDTO userRegistrationDTO, BindingResult bindingResult){
        LOGGER.info("UserEntity Email: ", userRegistrationDTO.getEmail());
        return userService.save(userRegistrationDTO);

    }

}
