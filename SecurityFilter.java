package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityFilter {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/public/**").permitAll() // Public URLs
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")  // Custom login page (optional)
                .permitAll()
            )
            .logout(logout -> logout.permitAll());

        return http.build();
    }
}
