package com.k15t.pat.registration.repository;

import com.k15t.pat.registration.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Parviz on 29.04.2018.
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
