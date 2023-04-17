package haku.com.chatApplication.security;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecSecurityConfig extends WebSecurityConfigurerAdapter{

	@Bean 
	public UserDeatilsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}
	
	@Bean 
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(16);
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}
	
	@Override
	protected void configure(HttpSecurity http)throws Exception{
		http.authorizeRequests(authorize -> authorize
				.antMatchers("/admin").hasRole("ADMIN") //Only users with ADMIN role can access /admin (need to hide admin option in nav bar from USERS)
				.anyRequest().authenticated()
		)
		.formLogin(form -> form
				.loginPage("/login")
				.defaultSuccessUrl("/dashboard")
				.permitAll()
		)
		.logout(logout -> logout
				.logoutUrl("/logout")
				.logoutSuccessUrl("/")
				.permitAll()
		);
		http.csrf().disable();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
		http.authorizeHttpRequests((requests) -> requests
				.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll() // Allow access to static resources
				.antMatchers("/", "/index", "/register").permitAll()  //these can be changed, these are pages allowed without logging in
				.anyRequest().authenticated()
		)
				.formLogin((form) -> form
					.loginPage("/login")
					.defaultSuccessUrl("/dashboard") //if successful login taken to Dashboard page
					.permitAll()
		)
				.logout(logout -> logout
						.logoutUrl("/logout")
						.logoutSuccessUrl("/")
						.permitAll()
		);
		http.csrf().disable();
		return http.build();
				
	}
}
