// package com.hutieugo.backend.security;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig {

//     private final JwtUtil jwtUtil;
//     private final AuthenticationConfiguration authenticationConfiguration;

//     public SecurityConfig(JwtUtil jwtUtil, AuthenticationConfiguration authenticationConfiguration) {
//         this.jwtUtil = jwtUtil;
//         this.authenticationConfiguration = authenticationConfiguration;
//     }

//     @Bean
//     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//         http
//             .csrf(csrf -> csrf.disable())
//             .authorizeHttpRequests(auth -> auth
//                 .requestMatchers("/api/users/register", "/api/users/login").permitAll() // Thay antMatchers bằng requestMatchers
//                 .anyRequest().authenticated()
//             )
//             .sessionManagement(session -> session
//                 .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//             )
//             .addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

//         return http.build();
//     }

//     @Bean
//     public JwtAuthenticationFilter jwtAuthenticationFilter() throws Exception {
//         return new JwtAuthenticationFilter(authenticationManager(), jwtUtil);
//     }

//     @Bean
//     public AuthenticationManager authenticationManager() throws Exception {
//         return authenticationConfiguration.getAuthenticationManager();
//     }
// }