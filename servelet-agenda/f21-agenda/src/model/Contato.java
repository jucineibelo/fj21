package model;

import java.time.LocalDateTime;

public class Contato {

	private Long id;
	private String name;
	private String endereco;
	private LocalDateTime dataNascimento;
	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public LocalDateTime getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDateTime dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Contato: " + id + "\nNome: " + name + "\nEndereço: " + endereco + "\nData de Nascimento: "
				+ dataNascimento + "\nEmail: " + email;
	}

}
