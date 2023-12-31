package com.ari.AuthenticationAuthorization;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //in memory
//        auth.inMemoryAuthentication()
//                .withUser("ari")
//                .password("ari")
//                .roles("user")
//                .and()
//                .withUser("sutha")
//                .password("sutha")
//                .roles("admin");
//        // JDBC Authontication
//        auth.jdbcAuthentication()
//                .dataSource(dataSource);
        auth.userDetailsService(userDetailsService);

        // below for user creation
//                .withDefaultSchema()
//                .withUser(
//                        User.withUsername("ari")
//                                .password("ari")
//                                .roles("user")
//                )
//                .withUser(
//                        User.withUsername("sutha")
//                                .password("sutha")
//                                .roles("admin")
//                );
    }

    // omit the pwd encription
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/user").hasAnyRole("USER","ADMIN")
                .antMatchers("/home").permitAll()
                .and()
                .formLogin();


    }
}
