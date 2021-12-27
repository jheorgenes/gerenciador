<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/novaEmpresa" var="linkServletNovaEmpresa" /><!-- Importação para atribuir um link para o formulário -->
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulário Nova Empresa</title>
</head>
<body>
    <form action="${ linkServletNovaEmpresa }" method="post"><!-- Definido a variável contendo a URL para a outra página -->
    	Nome: <input type="text" name="nome" />
    	Data Abertura: <input type="text" name="data" />
    	<input type="submit">
    </form>
</body>
</html>