package br.com.tcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tcc.model.Aluno;

/**
 * Repositório do Aluno
 * @author Poliana
 *
 */
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	
	public Aluno findByEmail(String email);

}
