package com.fast.logintest.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @Author: 文玉帆
 * @Description: TODO
 * @Date: 2026/5/6 13:47
 * @Version: 1.0
 */

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/login", "/","/api/register","/api/update").permitAll()
                        .anyRequest().authenticated()
                );

        return http.build();
    }
}
