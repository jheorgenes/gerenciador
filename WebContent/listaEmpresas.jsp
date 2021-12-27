<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@page import="java.util.List, br.com.alura.gerenciador.servlet.Empresa" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Java Standar Taglib</title>
	</head>
	<body>
		<c:if test="${ not empty empresa }">
	    	Empresa ${ empresa } cadastrada com sucesso!
	    </c:if>	
		Lista de empresas: <br />
		<ul>
			<c:forEach items="${empresas}" var="empresa"><!-- Utilizando a biblioteca jstl/core, � poss�vel fazer o foreach String literals como items e definido a vari�vel que iterar� a lista -->	
				<li>${ empresa.nome } - <fmt:formatDate value="${ empresa.dataAbertura }" pattern="dd/MM/yyyy"/></li><!-- Utilizando fmt para formatar Datas de acordo com o pattern definido (utiliza tags espec�ficas) -->
				<a href="/gerenciador/mostraEmpresa?id=${ empresa.id }">edita</a>
				<a href="/gerenciador/removeEmpresa?id=${ empresa.id }">remove</a>
			</c:forEach>
		</ul>	
	</body>
</html>