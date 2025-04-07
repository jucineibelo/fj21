package model;

import java.time.LocalDate;

public class Contato {

    private Long id;
    private String name;
    private String email;
    private String endereco;
    private LocalDate dataNascimento;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "Contato: " +
                "\nid: " + id +
                "\nname:" + name +
                "\nemail: " + email +
                "\nendereco: " + endereco +
                "\ndataNascimento: " + dataNascimento;
    }
}
