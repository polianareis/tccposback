package br.com.tcc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Classe de configuração da Segurança
 * @author Poliana
 *
 */
@EnableWebSecurity
public class SegurancaConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	/**
	 * Método que realiza a configuração do acesso
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/h2/**")
				.permitAll()
			.anyRequest()
				.authenticated()
			.and()
				.httpBasic()
			.and()
				.logout()
					.permitAll();
		http.csrf().disable();
		http.headers().frameOptions().disable();
		
	}
	/**
	 * Método que configura a validação do Aluno e define a criptografia
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}

}
