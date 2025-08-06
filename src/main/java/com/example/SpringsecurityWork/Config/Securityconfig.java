package com.example.SpringsecurityWork.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity   //to customise avialble spring security
public class Securityconfig {


@Bean
    public SecurityFilterChain security(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(authz->
                authz.requestMatchers("/auth").authenticated()
                        .requestMatchers("/home").permitAll()
                        .anyRequest().permitAll()
                ).formLogin(form->form.permitAll().defaultSuccessUrl("/auth"));
  return http.build();
    }
    @Bean
    public UserDetailsService userdetail(){
        UserDetails user= User
                .withUsername("sabari")
                .password(passwordencoder().encode("12345"))
                .roles("user")
                .build();
        UserDetails admin=User.withUsername("james").password(passwordencoder().encode("123")).roles("admin").build();
        return new InMemoryUserDetailsManager(user,admin);
    }
    @Bean
    public PasswordEncoder passwordencoder(){
    return new BCryptPasswordEncoder();
    }


}
