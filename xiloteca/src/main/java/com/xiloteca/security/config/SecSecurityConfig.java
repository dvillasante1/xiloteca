package com.xiloteca.security.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
//@Profile("!https")
public class SecSecurityConfig {

@Bean
public UserDetailsManager users(DataSource dataSource) {
		return new JdbcUserDetailsManager(dataSource);
		}
	

@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	http
	.csrf().disable()
    .authorizeHttpRequests((authz) -> authz
			.requestMatchers(HttpMethod.GET, "/css/**", "/js/**", "/img/**").permitAll()
			.anyRequest().authenticated())
    		.formLogin((form) -> form.loginPage("/login")
			.failureUrl("/loginError")
			.permitAll())
			.logout((logout) -> logout.permitAll());
	return http.build();
     
}
     
     @Bean
     public PasswordEncoder passwordEncoder() {
         return new BCryptPasswordEncoder();
     }
     
    
 }
