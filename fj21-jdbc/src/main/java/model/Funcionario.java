package model;

public class Funcionario {

    private Long id;

    private String name;

    private String usuario;

    private String senha;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Funcionario" +
                "\nid: " + id +
                "\nname: " + name +
                "\nusuario: " + usuario +
                "\nsenha: " + senha;
    }
}
