package br.propina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.propina.model.Edital;

@Repository
public interface EditalRepository extends JpaRepository<Edital, String>{

	Edital findByreferencia(String referencia);

}
