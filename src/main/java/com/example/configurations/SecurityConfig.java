package  com.example.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.service.CustomSuccessHandler;
import com.example.service.CustomUserDetailsService;



@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	
	@Autowired
	CustomSuccessHandler customSuccessHandler;
	
	@Autowired
	CustomUserDetailsService customUserDetailsService;
	
//	パスワードをハッシュ化
	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	/*
	 * 
	 * 
	 * */
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		 http.formLogin(login -> login
	                .loginProcessingUrl("/login")
	                .loginPage("/login")
	                .defaultSuccessUrl("/",true)
	                .failureUrl("/login?error")
	                .permitAll()
	        ).logout(logout -> logout
	                .logoutSuccessUrl("/")
	        ).authorizeHttpRequests(request -> request.requestMatchers(AntPathRequestMatcher.antMatcher("/registration")).permitAll()
					.anyRequest().authenticated()
	        );
	        return http.build();
		
	}
	
	@Autowired
	public void configure (AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
	}

}
