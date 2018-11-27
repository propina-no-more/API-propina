package br.propinanomore.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Prova {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long codProva;
	@Column(nullable= false)
	private String caminhaArquivo;
	@Column(nullable= false)
	private String tipoProva;
	
	public Prova() {
		// TODO Auto-generated constructor stub
	}
	
	public Prova(long codProva, String caminhaArquivo, String tipoProva) {
		this.codProva = codProva;
		this.caminhaArquivo = caminhaArquivo;
		this.tipoProva = tipoProva;
	}
	public long getCodProva() {
		return codProva;
	}
	public void setCodProva(long codProva) {
		this.codProva = codProva;
	}
	public String getCaminhaArquivo() {
		return caminhaArquivo;
	}
	public void setCaminhaArquivo(String caminhaArquivo) {
		this.caminhaArquivo = caminhaArquivo;
	}
	public String getTipoProva() {
		return tipoProva;
	}
	public void setTipoProva(String tipoProva) {
		this.tipoProva = tipoProva;
	}
}
