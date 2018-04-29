package com.k15t.pat.registration.domain.entity;

import com.k15t.pat.registration.domain.BaseEntity;
import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Parviz on 28.04.2018.
 */
@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"email"}, name = "UNIQUE_USER_EMAIL")}, indexes = {
        @Index(name = "INDEX_USER_NAME", columnList = "name")})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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

    @Column(length = 32)
    private String phoneNumber;

    @Embedded
    private Address address;

    @Embeddable
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
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
    }
}
