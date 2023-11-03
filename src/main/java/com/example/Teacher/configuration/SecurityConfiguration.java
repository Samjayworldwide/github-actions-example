//package com.example.Teacher.configuration;
//
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.web.SecurityFilterChain;
//
//
//@Configuration
//@EnableWebSecurity
//
////@EnableMethodSecurity
//public class SecurityConfiguration{
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//         http
//                 .securityMatcher("/loginTeacher")
//                .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry ->
//                        authorizationManagerRequestMatcherRegistry.requestMatchers("index")
//                                .permitAll()
//                                .anyRequest()
//                                .authenticated()
//                )
//                 .httpBasic(Customizer.withDefaults());
//                //.formLogin(Customizer.withDefaults());
//         return http.build();
//
//
//
//
//
//
//    }
//}
//
