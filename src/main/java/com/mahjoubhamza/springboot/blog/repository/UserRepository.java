package com.mahjoubhamza.springboot.blog.repository;

import com.mahjoubhamza.springboot.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * mim
 * 07/08/2019
 */

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmail(@Param("email") String email);

    Optional<User> findByUsername(@Param("username") String username);
}
