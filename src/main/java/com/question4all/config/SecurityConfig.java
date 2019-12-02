package com.question4all.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private DataSource dataSource;
	
	
	private String usersQuery="select emailid,password, '1' as enabled from users where emailid=? ";
	
	
	private String roleQuery="select u.emailid,r.role_desc from users u inner join auth_user_role ur on (u.id=ur.id) inner join auth_role r on (ur.auth_role_id=r.auth_role_id) where emailid=?";
	
	@Override
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.passwordEncoder(bCryptPasswordEncoder)
		.usersByUsernameQuery(usersQuery)
		.authoritiesByUsernameQuery(roleQuery);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
 		http.authorizeRequests()
		//url Matching For access rights
		.antMatchers("/").permitAll()
		.antMatchers("/login/**","/show").permitAll()
		.antMatchers("/adminlogin").permitAll()
		.antMatchers("/contactus/**").permitAll()
		.antMatchers("/signup/**").permitAll()
		.antMatchers("/admin*").hasAnyAuthority("ADMIN_USER")
		.antMatchers("/questionpapers*").hasAnyAuthority("ADMIN_USER","SITE_USER")
		.anyRequest().authenticated()
		.and()
		//form Login
		.csrf().disable().formLogin()
		.loginPage("/login")
		.failureUrl("/error")
		.defaultSuccessUrl("/admin")
		.usernameParameter("emailid")
		.passwordParameter("password")
		.and()
		//Logout
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/")
		.and()
		.exceptionHandling()
		.accessDeniedPage("/access-denied");
		
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		
		web.ignoring().antMatchers("/Resources/**","/static/**","/css/**","/admin-panel/**","/js/**","/css/bootstrap/**","/css/image/**","/css/myslider/css**","/css/myslider/image/slides/**","/css/bootstrap/css/**","/css/bootstrap/fonts/**","/css/bootstrap/js/**");
	}

}
