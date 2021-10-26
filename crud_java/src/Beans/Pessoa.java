package Beans;

public class Pessoa {
	
	private String Nome;
	private String Cpf;
	private int Idade;
	

	public Pessoa(String nome, String cpf) {
		this.Nome = nome;
		this.Cpf = cpf;
	
	}


	public Pessoa() {
		// TODO Auto-generated constructor stub
	}


	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCpf() {
		return Cpf;
	}

	public void setCpf(String cpf) {
		Cpf = cpf;
	}

	public int getIdade() {
		return Idade;
	}

	public void setIdade(int idade) {
		Idade = idade;
	}
	
	

	
}
