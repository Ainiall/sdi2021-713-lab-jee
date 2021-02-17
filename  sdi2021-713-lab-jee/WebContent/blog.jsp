<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="com.uniovi.sdi.* , java.util.List"%>
<! DOCTYPE html PUBLIC"-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<title>JSP:Blog</title>
	<meta charset="utf-8"/>
	<meta name="viewport" content="width=device-width, initial-scale=1"/>
	<link rel="stylesheet" 
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
<!--Contenido-->
<div class="container" id="contenedor-principal">
	<h2>BLOG</h2>
	<div class="row ">
		<jsp:useBean id="comentariosService" class="com.uniovi.sdi.ComentariosService"/>
		<c:forEach var="comentario" begin="0" items="${comentariosService.comentarios}">
		<div class="col-xs-12 col-sm-4 col-md-4 col-lg-3">
			<h3>
				<c:out value="${comentario.autor}"/>
			</h3>
			<div>
				<c:out value="${comentario.texto}"/>
			</div>

		</div>
		</c:forEach>
	</div>
	<div class="row">
	<a href="index.jsp">Volver</a>
	</div>
</div>
</body>
</html>