<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/entrada" var="linkEntradaServlet" /><!-- Importação para atribuir um link para o formulário -->
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulário Nova Empresa</title>
</head>
<body>
	<c:import url="logout-parcial.jsp" />
    <form action="${ linkEntradaServlet }" method="post"><!-- Definido a variável contendo a URL para a outra página -->
    	Nome: <input type="text" name="nome" value="${ empresa.nome }" /> <!-- Para ter acesso a String Literals no java, é necessário utilizar o nome do atributo e não utilizar os métodos get e set deles -->
    	Data Abertura: <input type="text" name="data" value="<fmt:formatDate value="${ empresa.dataAbertura }" pattern="dd/MM/yyyy"/>" />
    	<input type="hidden" name="id" value="${ empresa.id }">
    	<input type="hidden" name="acao" value="AlteraEmpresa">
    	<input type="submit">
    </form>
</body>
</html>