package br.com.tcc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.tcc.repository.AlunoRepository;
/**
 * Serviço que retorna os dados do aluno para realizar a autenticação
 * @author Poliana
 *
 */
@Service
public class LoginService implements UserDetailsService {
	
	@Autowired
	private AlunoRepository alunoRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserDetails userDetails = alunoRepository.findByEmail(email);
		if(null==userDetails) {
			throw new UsernameNotFoundException("Usuário "+email+" não encontrado"); 
		}
		return userDetails;
	}

}
