package servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FuncionarioDao;
import model.Funcionario;

@WebServlet("/adicionaFuncionario")
public class AdicionaFuncionarioServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");

        Funcionario funcionario = new Funcionario();
        funcionario.setName(name);
        funcionario.setUsuario(usuario);
        funcionario.setSenha(senha);

        FuncionarioDao dao = new FuncionarioDao();
        dao.adicionaFuncionario(funcionario);

        out.println("<html><body>");
        out.println("Funcionario " + funcionario.getName() + " adicionado com sucesso");
        out.println("</body></html>");
    }
}
