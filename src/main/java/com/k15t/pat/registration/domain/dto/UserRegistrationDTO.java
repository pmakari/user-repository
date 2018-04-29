package com.k15t.pat.registration.domain.dto;

import com.k15t.pat.registration.domain.entity.UserEntity;

/**
 * Created by Parviz on 29.04.2018.
 */
public class UserRegistrationDTO {
    private Long id;
    private String name;
    private String password;
    private String email;
    private String phoneNumber;
    private UserEntity.Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public UserEntity.Address getAddress() {
        return address;
    }

    public void setAddress(UserEntity.Address address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserRegistrationDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address=" + address.toString() +
                '}';
    }
}
