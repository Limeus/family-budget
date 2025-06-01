package com.limeus.commonlib.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ResourceServerSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
//                .csrf().disable() // Отключает CSRF для POST-запросов (например, через Postman)
//                .authorizeHttpRequests(auth -> auth
//                        .anyRequest().permitAll() // Разрешаем все запросы без токена
//                )
//                .oauth2ResourceServer().disable(); // Отключаем JWT/Resource Server
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest().permitAll()
                )
                .oauth2ResourceServer(AbstractHttpConfigurer::disable);

        return http.build();
    }
}