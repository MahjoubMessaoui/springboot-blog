package com.mahjoubhamza.springboot.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.activation.DataSource;

/**
 * mim
 * 08/08/2019
 */

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


//    final DataSource dataSource;
//
//    @Autowired
//    public SecurityConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests()
                //.antMatchers("/css/**", "/webjars/**").permitAll()
                .antMatchers("/home", "/registration", "/error", "/blog/**", "/post/**", "/h2-console/**").permitAll()
               // .antMatchers("/newPost/**", "/commentPost/**", "/createComment/**").hasAnyRole("USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/home")
                .permitAll()
                .and()
                .logout()
                .permitAll();
             //   .and()
             //   .exceptionHandling().accessDeniedHandler(accessDeniedHandler)
                // Fix for H2 console
               // .and().headers().frameOptions().disable();
    }
}
