package br.propina.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.propina.model.Prova;

@Repository
public interface ProvaRepository extends JpaRepository<Prova, Long>{

	@Query("SELECT p FROM Prova p WHERE codProva = ?1")
	public Prova findcodProva(Long codProva);

}
