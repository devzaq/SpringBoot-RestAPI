package com.dz.rest.webservices.restful_web_services.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//      1. All the request should be authenticated
        httpSecurity.authorizeHttpRequests(auth-> auth.anyRequest().authenticated());
//      2. If request is not authenticated a webpage is shown
        httpSecurity.httpBasic(Customizer.withDefaults());
//      3. CSRF -> POST, PUT
        httpSecurity.csrf().disable();
        return httpSecurity.build();
    }
}
