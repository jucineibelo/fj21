package application;
import java.sql.Connection;
import java.time.LocalDateTime;

import dao.ContatoDao;
import dao.FuncionarioDao;
import factory.ConnectionFactory;
import model.Contato;
import model.Funcionario;

public class AppMainTest {
	public static void main(String[] args) {

		// Teste de conexão
		ConnectionFactory teste = new ConnectionFactory();
		Connection testeConexão = teste.getConnection();
		System.out.println("Connectou");
		
		
		//Teste de insert funcionario
		Funcionario f1 = new Funcionario();
		f1.setName("Bundancio");
		f1.setUsuario("curack");
		f1.setSenha("5645");
		
		System.out.println("Funcionario salvo com sucesso! " + f1);
		
		
		FuncionarioDao dao = new FuncionarioDao();
		dao.adicionaFuncionario(f1);
		
		//Teste insert Contato
		
		Contato c1 = new Contato();
		c1.setName("teste contato");
		c1.setEndereco("Rua sem fim");
		c1.setDataNascimento(LocalDateTime.now());
		
		ContatoDao contatoDao = new ContatoDao();
		contatoDao.adicionaContato(c1);
		System.out.println("Contato Salvo com sucesso!" + "\n" + c1);
	}

}
