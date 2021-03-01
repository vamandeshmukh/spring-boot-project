package com.vaman.spring.boot.demo.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private final Logger log = LoggerFactory.getLogger(JwtUtil.class);

	@Autowired
	private UserDetailsService myUserDetailsService;

	@Autowired
	private UserRequestFilter userRequestFilter;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		log.info("configureGlobal");
		auth.userDetailsService(myUserDetailsService);
	}

//	this method has no real use 
//	@SuppressWarnings("deprecation")
	@Bean
	public PasswordEncoder passwordEncoder() {
		log.info("passwordEncoder");
//		return BCryptPasswordEncoder.encode("vaman");
//		return NoOpPasswordEncoder.getInstance();
		return MyNoOpPasswordEncoder.getInstance();
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		log.info("authenticationManagerBean");
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception { // 2
		log.info("configure");
		httpSecurity.csrf().disable().authorizeRequests()
		.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()		
//		.antMatchers("/*").permitAll()
//		.antMatchers("/").permitAll()
		.antMatchers("/hello").permitAll()
		.antMatchers("/login").permitAll()
//		.antMatchers("/departments").permitAll()
				.anyRequest().authenticated().and().exceptionHandling().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		httpSecurity.addFilterBefore(userRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}
}
