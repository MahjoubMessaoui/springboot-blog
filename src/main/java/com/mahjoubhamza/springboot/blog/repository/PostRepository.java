package com.mahjoubhamza.springboot.blog.repository;

import com.mahjoubhamza.springboot.blog.model.Post;
import com.mahjoubhamza.springboot.blog.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * mim
 * 07/08/2019
 */
public interface PostRepository extends JpaRepository<Post, Long> {
        Page<Post> findByUserOrderByCreateDateDesc(User user, Pageable pageable);

        Page<Post> findAllByOrderByCreateDateDesc(Pageable pageable);

        Optional<Post> findById(Long id);
        }