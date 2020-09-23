<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="dao" class="br.insper.edu.DAO"/>
<table border="1">
	<c:forEach var="pessoas" items="${dao.lista}">
		<tr>
			<td>${pessoa.nome}</td>
			<td>${pessoa.idade}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>