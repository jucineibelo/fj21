<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Bem-vindo</title>
</head>
<body>

  <%-- Coment�rio em JSP: nossa primeira p�gina --%>
  <%
    String mensagem = "Bem vindo ao nosso sistema de agenda FJ-21!";
    String desenvolvido = "Desenvolvido por Juc�o";
  %>

  <h1><%=mensagem%></h1>

  <div><%=desenvolvido%></div>

  <br />

  <%
    System.out.println("Tudo deu certo!");
  %>

</body>
</html>
