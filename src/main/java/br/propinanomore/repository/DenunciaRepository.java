package br.propinanomore.repository;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;

import br.propinanomore.models.Denuncia;

public interface DenunciaRepository extends JpaRepository<Denuncia,String>{

	Denuncia findCodDenuncia(@Valid long codDenuncia);

	List<Denuncia> findNome(@Valid String nome);

	
}
