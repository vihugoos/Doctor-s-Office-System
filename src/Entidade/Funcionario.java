package Entidade;


import java.util.Date;

public abstract class Funcionario {

	private Long id;
	private String nome;
	private String cpf;
	private String rg;
	private String telefone;	
	private Date dataNasc;
	private String sexo;
	private String endereco;
	private String cargo;
		
	public void setId(Long id) {
			this.id = id;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getCpf() {
		return this.cpf;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getTelefone() {
		return this.telefone;
	}
	
	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}
	
	public Date getDataNasc() {
		return this.dataNasc;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public String getSexo() {
		return this.sexo;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getEndereco() {
		return this.endereco;
	}
	
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public String getCargo() {
		return this.cargo;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	
}
