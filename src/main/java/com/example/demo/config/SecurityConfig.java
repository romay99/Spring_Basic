package com.example.demo.config;

import com.example.demo.filter.CustomGenericFilter;
import com.example.demo.filter.CustomOnceFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * 시큐리티 필터 체인 등록하는 메서드
     */
    @Bean
    @Order(1) // 필터체인 인덱스 순서 정해주는 어노테이션
    public SecurityFilterChain customFilterChain1(HttpSecurity http) throws Exception {
        // 경로에대한 설정
        http
                .authorizeHttpRequests((auth) -> auth.anyRequest().permitAll());
        // 커스텀 필터 추가
        http
                .addFilterAfter(new CustomGenericFilter(), LogoutFilter.class);
        http
                .addFilterAfter(new CustomOnceFilter(),LogoutFilter.class);
        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        // 아래처럼 적어두면 img 경로에 해당하는 img 파일들을 필터 해제할 수 있다.
        // 내부에 필터가 존재하지 않는 필터체인이 생성되서 인덱스 0 번에 설정된다.
        return web -> web.ignoring().requestMatchers("/img/**");
    }
}
