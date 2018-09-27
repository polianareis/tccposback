package br.com.tcc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * Controlador que permite o get na raiz 
 * @author Poliana
 *
 */
@RestController
public class PrincipalController {

	@RequestMapping("/")
	public String login() {
		return "Login";
	}
}
