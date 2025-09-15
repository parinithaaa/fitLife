package com.parinitha.fit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests((requests) -> requests.requestMatchers("/**").permitAll()
				.requestMatchers("style.css").permitAll()
				.requestMatchers("/contact","/home","/login","/register").permitAll().requestMatchers("/formSubmit").permitAll())
				.formLogin(loginConfigurer -> loginConfigurer.loginPage("/login").defaultSuccessUrl("/contact")
						.failureUrl("/login?error=true").permitAll())
				.httpBasic(Customizer.withDefaults());
		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
