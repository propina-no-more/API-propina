package br.propina.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.propina.model.Orgao;

@Repository
public interface OrgaoRepository extends JpaRepository<Orgao, String>{

	@Query("SELECT o.nome, o.sigla, count(d) as quantidade  FROM Denuncia d "
			+ "INNER JOIN Orgao o ON o.codOrgao = d.orgao "
			+ "GROUP BY o.nome, o.sigla ORDER BY count(d) desc")
	List<Orgao> findTopDenuncia();

	Orgao findBynome(String nome);

}
