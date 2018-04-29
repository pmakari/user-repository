package com.k15t.pat.registration.domain.entity;

import com.k15t.pat.registration.domain.BaseEntity;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Parviz on 28.04.2018.
 */
@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    @NotBlank
    @Column(nullable = false, length = 128)
    private String name;

    @NotBlank
    @Column(nullable = false, length = 64)
    private String password;

    @NotBlank
    @Column(nullable = false, length = 128)
    private String email;

    @Column(length = 64)
    private String phoneNumber;
    @Embedded
    private Address address;

    @Embeddable
    public static class Address {
        @NotBlank
        @Column(nullable = false, length = 128)
        private String country;
        @NotBlank
        @Column(nullable = false, length = 128)
        private String city;
        @NotBlank
        @Column(nullable = false, length = 128)
        private String street;
        @NotBlank
        @Column(nullable = false, length = 32)
        private String zipCode;
        @NotNull
        @Column(nullable = false)
        private Short houseNumber;

        public Address() {
        }

        public Address(String country, String city, String street, String zipCode, Short houseNumber) {
            this.country = country;
            this.city = city;
            this.street = street;
            this.zipCode = zipCode;
            this.houseNumber = houseNumber;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getZipCode() {
            return zipCode;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }

        public Short getHouseNumber() {
            return houseNumber;
        }

        public void setHouseNumber(Short houseNumber) {
            this.houseNumber = houseNumber;
        }

        @Override
        public String toString() {
            return "Address{" +
                    "country='" + country + '\'' +
                    ", city='" + city + '\'' +
                    ", street='" + street + '\'' +
                    ", zipCode='" + zipCode + '\'' +
                    ", houseNumber=" + houseNumber +
                    '}';
        }
    }

    public UserEntity(String name, String email, String phoneNumber, Address address) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public UserEntity(String name, String password, String email, String phoneNumber, Address address) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public UserEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
