package br.propina.model;

import java.io.Serializable;

public class DenunciaDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String sigla;
	private String orgao;
	private String numDenuncia;

	public DenunciaDTO() {
	}
	
	public DenunciaDTO( String sigla, String orgao, String numDenuncia) {
		
		this.sigla = sigla;
		this.orgao = orgao;
		this.numDenuncia = numDenuncia;
	}
	
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getOrgao() {
		return orgao;
	}
	public void setOrgao(String orgao) {
		this.orgao = orgao;
	}
	public String getNumDenuncia() {
		return numDenuncia;
	}
	public void setNumDenuncia(String numDenuncia) {
		this.numDenuncia = numDenuncia;
	}
}
