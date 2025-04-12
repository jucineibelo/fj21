package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContatoDao;
import model.Contato;

@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		String endereco = request.getParameter("endereco");
		String dataNascimento = request.getParameter("dataNascimento");

		LocalDateTime dataNascimentoConvertida = LocalDateTime.parse(dataNascimento);

		Contato contato = new Contato();
		contato.setName(name);
		contato.setEndereco(endereco);
		contato.setDataNascimento(dataNascimentoConvertida);

		ContatoDao dao = new ContatoDao();
		dao.adicionaContato(contato);

		out.println("<html><body>");
		out.println("Contato " + contato.getName() + " adicionado com sucesso");
		out.println("</body></html>");
	}
}
