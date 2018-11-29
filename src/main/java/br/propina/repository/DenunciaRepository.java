package br.propina.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.propina.model.Denuncia;

@Repository
public interface DenunciaRepository extends JpaRepository<Denuncia, String> {

	@Query("SELECT d FROM Denuncia d "
			+ "INNER JOIN Edital e ON e.codEdital = d.edital "
			+ "INNER JOIN Orgao o ON o.codOrgao = e.orgao_id "
			+ "INNER JOIN Orgao r ON r.codOrgao = d.orgao "
			+ "WHERE o.nome LIKE %?1% OR r.nome LIKE %?1%")
	List<Denuncia> findnome(String nome);

	@Query ("SELECT d FROM Denuncia d WHERE d.codDenuncia = ?1")
	Denuncia findcodDenuncia(long codDenuncia);

}
