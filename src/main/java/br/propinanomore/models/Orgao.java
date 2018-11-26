package br.propinanomore.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Orgao {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long codOrgao;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String sigla;
	
	public Orgao(Long codOrgao, String nome, String sigla) {
		this.codOrgao = codOrgao;
		this.nome = nome;
		this.sigla = sigla;
	}
	public Long getCodOrgao() {
		return codOrgao;
	}
	public void setCodOrgao(Long codOrgao) {
		this.codOrgao = codOrgao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
}
