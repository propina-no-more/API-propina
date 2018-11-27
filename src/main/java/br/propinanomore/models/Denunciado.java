package br.propinanomore.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Denunciado {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codDenunciado;
	private String cargo;
	private String infoAdicional;
	private String nome;
	
	public Denunciado() {
		// TODO Auto-generated constructor stub
	}
	public Denunciado(Long codDenunciado, String cargo, String infoAdicional, String nome) {
		this.codDenunciado = codDenunciado;
		this.cargo = cargo;
		this.infoAdicional = infoAdicional;
		this.nome = nome;
	}
	public Long getCodDenunciado() {
		return codDenunciado;
	}
	public void setCodDenunciado(Long codDenunciado) {
		this.codDenunciado = codDenunciado;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getInfoAdicional() {
		return infoAdicional;
	}
	public void setInfoAdicional(String infoAdicional) {
		this.infoAdicional = infoAdicional;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
