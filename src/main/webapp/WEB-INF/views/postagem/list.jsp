<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Postagens</title>
<link type="text/css" rel="stylesheet" href="<c:url value="/css/style.css"/>">
</head>
<body>
<c:import url="../menu.jsp"/>
<br/>
	<fieldset>
		<legend>Lista de Postagens</legend>
		<table class="table">
			<tr>
				<th>Código</th>
				<th>Título</th>
				<th>Permalink</th>
				<th>Data de Postagem</th>
				<th>Autor</th>
				<th>Categorias</th>
				<th>Ação</th>
			</tr>
			<c:forEach var="postagem" items="${postagens}" varStatus="i">
			<tr bgcolor="${i.count % 2 != 0 ? '#f1f1f1' : 'white'}">
				<td>${postagem.id }</td>
				<td>${postagem.titulo}</td>
				<td>${postagem.permalink}</td>
				<td>${postagem.dataPostagem}</td>
				<td>${postagem.autor.nome}</td>
				<td>
					<c:forEach var="c" items="${postagem.categorias }">
						[${c.descricao } ]
					</c:forEach>
				</td>
				<td>
					<c:url var="update" value="/postagem/update/${postagem.id }"></c:url>
					<c:url var="delete" value="/postagem/delete/${postagem.id }"></c:url>
					
					<a href="${update }" title="Editar">&#9445</a>
					<a href="${delete }" title="Excluir">&#9447</a>
				</td>
				
			</tr>
			</c:forEach>
		</table>
	</fieldset>
</body>
</html>