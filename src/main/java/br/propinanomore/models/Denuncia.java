package br.propinanomore.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Denuncia {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codDenuncia;
	@Column(nullable= false)
	private int ano;
	private String cpf;
	private String nome;
	private String onde;
	private String oque;
	private String quando;
	private char sigilo;
	private String telefone;
	@OneToOne
	@JoinColumn(name="")
	private Edital edital;
	private Orgao orgao;
	
}
