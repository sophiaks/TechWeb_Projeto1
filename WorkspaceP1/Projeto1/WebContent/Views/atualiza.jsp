<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.*,br.edu.insper.*" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Tarefa</title>
<link href="<c:url value="/bootstrap/css/bootstrap.css"/>" rel="stylesheet">

</head>
<body>
	<jsp:useBean id="dao" class="br.edu.insper.model.DAO"/>
	<form action="atualiza" method="post">
	
	<div class="form-group">
			<label for="nome">Tarefa</label>
			<input type="text" name="nome" class="form-control" placeholder="Tarefa" value='${param.nome}'>
	</div>
	
	<div class="form-group">
			<label for="nome">Data de Entrega</label>
			<input type="date" name="entrega" class="form-control" placeholder="Data de Entrega" value='${param.entrega}'>
	</div>
	
	<div class="form-group">
		<label for="descricao">Descri��o</label>
		<input type="text" name="descricao" class="form-control" placeholder="Descri��o" value='${param.descricao}'>
	</div>
	
	
	<input type='hidden' name='id' value='${param.id}'>

	<input type='submit' value='Atualizar' class="btn btn-success">
	</form>
</body>
</html>