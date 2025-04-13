<%@ page import="java.util.List"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="cabecalho.jsp"/>
<jsp:useBean id="dao" class="dao.ContatoDao" />
<html>
<body>
	<table>
		<c:forEach var="contato" items="${dao.lista}">
			<tr>
				<td>${contato.name}</td>
				<td>${contato.dataNascimento}</td>
				<td>
					<c:if test="${not empty contato.email}">
						<a href="mailto:${contato.email}">${contato.email }</a>
					</c:if> 
					
					<c:if test="${empty contato.email}">
						E-mail não informado
					</c:if>
					
				</td>
				<td>${contato.endereco}</td>
			</tr>
		</c:forEach>
	</table>
	<c:import url="rodape.jsp"/>
</body>

</html>