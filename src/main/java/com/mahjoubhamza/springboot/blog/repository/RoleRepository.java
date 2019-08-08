package com.mahjoubhamza.springboot.blog.repository;

import com.mahjoubhamza.springboot.blog.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * mim
 * 07/08/2019
 */
public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findByRoleName(@Param("role") String role);
}
