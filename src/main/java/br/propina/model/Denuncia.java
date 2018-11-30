package br.propina.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Denuncia implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codDenuncia;
	@Column(nullable= false)
	private int ano;
	private String cpf;
	private String nome;
	@Column(nullable= false)
	private String onde;
	@Column(nullable= false)
	private String oque;
	@Column(nullable= false)
	private String quando;
	@Column(nullable= false)
	private char sigilo;
	private String telefone;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	private Edital edital;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private Orgao orgao;
	
	@ManyToMany(cascade=CascadeType.MERGE)
	@JoinTable(name = "denuncia_prova",
				joinColumns = @JoinColumn(name="den_codDenuncia"),
				inverseJoinColumns = @JoinColumn(name="den_codProva"))
	private List<Prova> provas;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name = "denuncia_denunciado",
				joinColumns = @JoinColumn(name="den_codDenuncia"),
				inverseJoinColumns = @JoinColumn(name="den_codDenunciado"))
	private List<Denunciado> denunciado;
	
	public Denuncia() {
	}
	
	public Denuncia(Long codDenuncia, int ano, String cpf, String nome, String onde, String oque, String quando,
			char sigilo, String telefone, Edital edital, Orgao orgao) {
		this.codDenuncia = codDenuncia;
		this.ano = ano;
		this.cpf = cpf;
		this.nome = nome;
		this.onde = onde;
		this.oque = oque;
		this.quando = quando;
		this.sigilo = sigilo;
		this.telefone = telefone;
		this.edital = edital;
		this.orgao = orgao;
	}
	
	public List<Prova> getProvas() {
		return provas;
	}

	public void setProvas(List<Prova> provas) {
		this.provas = provas;
	}

	public Long getCodDenuncia() {
		return codDenuncia;
	}
	public void setCodDenuncia(Long codDenuncia) {
		this.codDenuncia = codDenuncia;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getOnde() {
		return onde;
	}
	public void setOnde(String onde) {
		this.onde = onde;
	}
	public String getOque() {
		return oque;
	}
	public void setOque(String oque) {
		this.oque = oque;
	}
	public String getQuando() {
		return quando;
	}
	public void setQuando(String quando) {
		this.quando = quando;
	}
	public char getSigilo() {
		return sigilo;
	}
	public void setSigilo(char sigilo) {
		this.sigilo = sigilo;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Edital getEdital() {
		return edital;
	}
	public void setEdital(Edital edital) {
		this.edital = edital;
	}
	public Orgao getOrgao() {
		return orgao;
	}
	public void setOrgao(Orgao orgao) {
		this.orgao = orgao;
	}	
}
