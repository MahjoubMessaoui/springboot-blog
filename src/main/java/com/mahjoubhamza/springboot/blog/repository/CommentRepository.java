package com.mahjoubhamza.springboot.blog.repository;

import com.mahjoubhamza.springboot.blog.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * mim
 * 07/08/2019
 */
public interface CommentRepository  extends JpaRepository<Comment, Long> {
}