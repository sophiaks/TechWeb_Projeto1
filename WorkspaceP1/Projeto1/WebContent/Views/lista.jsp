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
	<jsp:useBean id="dao" class="br.edu.insper.DAO"/>
	<a href="<%=request.getContextPath()%>/adiciona"
					class="btn btn-success">Adicionar Tarefa</a>
	<table border='1'>
				<thead>
					<tr>
						<th>Tarefa</th>
						<th>Data de Entrega</th>
						<th>Descri��o</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="tarefa" items="${dao.lista}">
						<tr>
							<td>${tarefa.nome}</td>
							<td>${tarefa.entrega}</td>
							<td>${tarefa.descricao}</td>
							
							<td><form action="remove" method="post">
							<input type="hidden" name='id' value='${tarefa.id}'>
							<input type="submit" value="remover">
							</form>
							</td>
							
							<td><form action="atualiza" method="get">
							<input type="hidden" name='id' value='${tarefa.id}'>
							<input type="hidden" name='nome' value='${tarefa.nome}'>
							<input type="hidden" name='entrega' value='${tarefa.entrega}'>
							<input type="hidden" name='descricao' value='${tarefa.descricao}'>
							<input type="submit" value="Editar">
							</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
</table>
</body>
</html>