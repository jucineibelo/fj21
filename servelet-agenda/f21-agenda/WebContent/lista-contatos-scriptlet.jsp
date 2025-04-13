<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="model.Contato"%>
<%@page import="dao.ContatoDao"%>
<%@page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Contatos</title>
</head>
<body>

	<h1>Lista de Contatos</h1>

	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Endereço</th>
				<th>Data de Nascimento</th>
				<th>E-mail</th>
			</tr>
		</thead>
		<tbody>
			<%
				ContatoDao dao = new ContatoDao();
				List<Contato> contatos = dao.getLista();
				for (Contato contato : contatos) {
			%>
			<tr>
				<td><%=contato.getId()%></td>
				<td><%=contato.getName()%></td>
				<td><%=contato.getEndereco()%></td>
				<td><%=contato.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))%></td>
				<td><%=contato.getEmail()%></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>

	<div>Desenvolvido por Jucão</div>

</body>
</html>
