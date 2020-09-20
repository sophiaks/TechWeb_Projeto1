<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Tarefas</title>
</head>
<body>
<table border="1">
	<c:forEach var="tarefa" items="${tarefas}">
		<tr>
			<td>${tarefa.tarefa}</td>
			<td>${tarefa.data}</td>
			<td>${tarefa.descricao}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>