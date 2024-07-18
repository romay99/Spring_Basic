package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * 시큐리티 필터 체인 등록하는 메서드
     */
    @Bean
    @Order(1) // 필터체인 인덱스 순서 정해주는 어노테이션
    public SecurityFilterChain customFilterChain1(HttpSecurity http) throws Exception {
        //필터체인에 대한 설정 (필터체인이 여러개일경우 필수)
        http
                .securityMatchers(auth-> auth.requestMatchers("/user"));

        // 경로에대한 설정
        http
                .authorizeHttpRequests((auth) -> auth.anyRequest().permitAll());
        return http.build();
    }

    @Bean
    @Order(2)
    public SecurityFilterChain customFilterChain2(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((auth) -> auth.anyRequest().permitAll());
        return http.build();
    }
}
