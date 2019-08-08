package com.mahjoubhamza.springboot.blog.service;

import com.mahjoubhamza.springboot.blog.model.User;

import java.util.Optional;

/**
 * mim
 * 08/08/2019
 */
public interface UserService {

    /**
     * get user by email if there is a user
     *
     * @param username
     * @return
     */
    Optional<User> findByUsername(String username);

    /**
     * get user by email if thjere is a user
     *
     * @param email
     * @return
     */
    Optional<User> findByEmail(String email);

    /**
     * Save user
     *
     * @param user
     * @return
     */
    User save(User user);
}
