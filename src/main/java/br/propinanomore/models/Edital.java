package br.propinanomore.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Edital {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	private Long codEdital;
	@Column(nullable= false)
	private String ganhador;
	@Column(nullable= false)
	private String objetoLicitado;
	@Column(nullable= false)
	private String referencia;
	@Column(nullable= false)
	private String status;
	@OneToOne
	@JoinColumn(name="codOrgao")
	private Orgao orgao_id;
	
	
	public Edital(Long codEdital, String ganhador, String objetoLicitado, String referencia, String status,
			Orgao orgao_id) {
		this.codEdital = codEdital;
		this.ganhador = ganhador;
		this.objetoLicitado = objetoLicitado;
		this.referencia = referencia;
		this.status = status;
		this.orgao_id = orgao_id;
	}
	
	public Long getCodEdital() {
		return codEdital;
	}
	public void setCodEdital(Long codEdital) {
		this.codEdital = codEdital;
	}
	public String getGanhador() {
		return ganhador;
	}
	public void setGanhador(String ganhador) {
		this.ganhador = ganhador;
	}
	public String getObjetoLicitado() {
		return objetoLicitado;
	}
	public void setObjetoLicitado(String objetoLicitado) {
		this.objetoLicitado = objetoLicitado;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Orgao getOrgao_id() {
		return orgao_id;
	}
	public void setOrgao_id(Orgao orgao_id) {
		this.orgao_id = orgao_id;
	}
}
