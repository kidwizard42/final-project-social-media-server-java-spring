package com.leaderboard.gameSocialMedia.security;


import org.springframework.security.config.annotation.web.builders.HttpSecurity;

// SETS MY DEFAULT USER SHOUT OUT TO
// https://www.websparrow.org/spring/spring-security-how-to-change-default-username-and-password#:~:text=Note%3A%20By%20default%2C%20username%20for,your%2Dpassword%3E%E2%80%9D%20text.
//https://www.baeldung.com/spring-security-cors-preflight
//team treehouse java web dev course
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .csrf().disable();

        http.cors();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {

        // add users in List
        List<UserDetails> users = new ArrayList<UserDetails>();

        users.add(User.withDefaultPasswordEncoder()
                .username("blah")
                .password("blah").roles("USER").build());

        return new InMemoryUserDetailsManager(users);
    }
}

