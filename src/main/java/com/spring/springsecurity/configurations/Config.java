package com.spring.springsecurity.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class Config extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Kshitij").password("$2a$10$N1CeKzIr47Pf8LrBTk/baOsNPoV7Ui9egHh0ClB3y9mI34fChZSym").authorities("FACULTY")
                .and()
                .withUser("Manoj").password("$2a$10$KjVgXJAnIZR8gjS68ftB8u.50JhrC1wwDoVpGPgvpJJ/RYoEC/5SK").authorities("STUDENT");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/student/**").hasAuthority("STUDENT")
                .antMatchers("/faculty/**").hasAuthority("FACULTY")
                .antMatchers("/**").permitAll()
                .and().formLogin();
    }

    @Bean
    public PasswordEncoder bcryptPasswordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
    // plaintextpasswordencoder
//    @Bean
//    public PasswordEncoder passwordEncoder()
//    {
//        return NoOpPasswordEncoder.getInstance();
//    }
}
