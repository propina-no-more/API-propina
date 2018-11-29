package br.propina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.propina.model.Orgao;

@Repository
public interface OrgaoRepository extends JpaRepository<Orgao, String>{

}
