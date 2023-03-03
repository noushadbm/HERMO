package com.hermo.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@EnableWebSecurity
public class SecurityConfig {
    private static final String[] AUTH_WHITELIST = {"/api/test/**", "/h2-console", "/h2-console/**"};

    @Bean
    public SecurityFilterChain getSecurityFilter(HttpSecurity http) throws Exception {
        http.formLogin();

        http.authorizeRequests().anyRequest().permitAll();

//        http.authorizeRequests()
//                .antMatchers(AUTH_WHITELIST).permitAll()
//                .antMatchers("/ui/**").hasAnyRole("ADMIN", "USER")
//                .antMatchers(HttpMethod.POST, "/api/v1/employees").hasAnyRole("ADMIN", "USER")
//                .antMatchers(HttpMethod.GET, "/api/v1/employees").hasRole("ADMIN")
//                .antMatchers( "/api/v1/employees/**").hasRole("ADMIN") // Admin can do UPDATE/DELETE by id
//                .anyRequest().authenticated();

        // Without disabling CSRF, you will get 403 for POST/PUT/DELETE calls.
        http.csrf().disable().cors(); // To allow POST/PUT/DELETE
        http.headers().frameOptions().disable(); // This is required to access H2 Console.
        return http.build();
    }

    // Use this bean, if you want to fetch the user from memory (Not in db.)
    @Bean
    public InMemoryUserDetailsManager userDetailsService2() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        UserDetails user1 = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("password")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, user1);
    }

    // TODO: Delete this config. Used only when UI is running separately.
    @Bean
    CorsConfigurationSource corsConfigurationSource()
    {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000", "http://localhost:8080/"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST", "DELETE", "PUT"));
        configuration.setAllowedHeaders(Arrays.asList("authorization","content-type"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
