package br.propina.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Prova implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long codProva;	
	private String nome;
	@Lob
	private byte[] arquivo;
	
	private String tipoArquivo;
	
	
	public Prova() {
		// TODO Auto-generated constructor stub
	}
	
	public Prova( String nome, byte[] arquivo, String tipoArquivo) {
		this.nome = nome;
		this.arquivo = arquivo;
		this.tipoArquivo = tipoArquivo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipoArquivo() {
		return tipoArquivo;
	}

	public void setTipoArquivo(String tipoArquivo) {
		this.tipoArquivo = tipoArquivo;
	}


	public long getCodProva() {
		return codProva;
	}


	public void setCodProva(long codProva) {
		this.codProva = codProva;
	}


	public byte[] getArquivo() {
		return arquivo;
	}


	public void setArquivo(byte[] arquivo) {
		this.arquivo = arquivo;
	}
}
