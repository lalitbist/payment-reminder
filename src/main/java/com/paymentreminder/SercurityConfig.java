package com.paymentreminder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
/**
 * 
 * @author lalit_bist
 *
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true) // (securedEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SercurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	UserDetailsService userDetailsService;
	
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	        	.authorizeRequests()
	                //.antMatchers("/", "/login", "/process","/registeration").permitAll()
	               	.antMatchers("/welcome", "/users/**").hasAuthority("ADMIN") //This is a synonym for hasRole("ADMIN")
	               // .anyRequest().fullyAuthenticated()
	               .and()
	            .formLogin()
	                .loginPage("/login")
	                .failureUrl("/login?error")
	                .defaultSuccessUrl("/login/success")
	                //.loginProcessingUrl("/login/process")
	                .usernameParameter("email")
	                .permitAll()
	                .and()
	            .logout()
	                .logoutUrl("/logout")
	                //.deleteCookies("remember-me")
	                .logoutSuccessUrl("/")
	                .permitAll()
	                .and()
	                .csrf().disable(); // for now
	                //.rememberMe();
	    }
	 
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService)
		.passwordEncoder(new BCryptPasswordEncoder());
	}

}
