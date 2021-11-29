package modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import modelo.Pessoa;

/**
 * Entity implementation class for Entity: PessoaFisica
 * 
 */
@Entity
@DiscriminatorValue("PF")
public class PessoaFisica extends Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	private String cpf;
	private String rg;
	private Date dataNascimento;
	private Sexo sexo;
	
	public PessoaFisica() {
		super();
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return this.rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Date getDataNascimento() {
		return this.dataNascimento;
	}
	
	@Temporal(TemporalType.DATE)
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	@Enumerated
	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	
}