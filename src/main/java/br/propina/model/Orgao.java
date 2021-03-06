package br.propina.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Orgao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long codOrgao;
	@Column(nullable = false, unique=true)
	private String nome;
	@Column(nullable = false, unique=true)
	private String sigla;
	@Transient
	private int quantidade;
	
	
	public Orgao() {
		// TODO Auto-generated constructor stub
	}
	public Orgao(Long codOrgao, String nome, String sigla) {
		this.codOrgao = codOrgao;
		this.nome = nome;
		this.sigla = sigla;
	}
	
	
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
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
