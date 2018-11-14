package com.galvanize.gmdb.gmdb.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomBasicAuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("reviewer")
                .password(passwordEncoder().encode("reviewer"))
                .roles("REVIEWER", "USER")
                .and()
                .withUser("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN", "USER");

//If you need to manage multiple users with multiple Roles:
//        auth
//                .inMemoryAuthentication()
//                .withUser("user")  // #1
//                .password("password")
//                .roles("USER")
//                .and()
//                .withUser("admin") // #2
//                .password("password")
//                .roles("ADMIN","USER");


    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/movie/**").authenticated()
                .antMatchers(HttpMethod.PUT, "/movie/**").authenticated()
                .antMatchers(HttpMethod.DELETE, "/movie/**").authenticated()
                //.antMatchers("/movie/**").hasRole("ADMIN")
                .antMatchers("/movie/add").hasRole("ADMIN")
                .antMatchers("/movie/delete/**").hasRole("ADMIN")
                .antMatchers("/movie/update").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/review/**").authenticated()
                .antMatchers(HttpMethod.PUT, "/review/**").authenticated()
                .antMatchers(HttpMethod.DELETE,"/review/**").authenticated()
                .antMatchers("/review/**").hasRole("REVIEWER")
                .antMatchers("/review/**").hasRole("ADMIN")
                //  .antMatchers("/admin/**").hasRole("ADMIN") <= Example to show how to check a role
                .anyRequest().permitAll()
                .and()
                .httpBasic()
                .authenticationEntryPoint(authenticationEntryPoint).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterAfter(new CustomFilter(),
                BasicAuthenticationFilter.class);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
