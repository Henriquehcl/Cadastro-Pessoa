<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("contatos");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agenda</title>
<link rel="icon" href="images/favicon.svg">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div
		class="container-fluid blockquote text-center border-bottom border-success">
		<h3>Cadastro de Pessoas</h3>
		<small class="text-muted">
			<p> <h6>Desenvolvido por Henrique Lima<h6></p>
		</small>
		<div class="icones" style="padding-bottom: 1rem;">
			<img src="images/bootstrap.png" alt="bootstrap">
			 <img src="images/css3.svg" alt="css3"> 
			 <img src="images/html5.svg" alt="html5"> 
			 <img src="images/java.svg" alt="java"> 
				<img src="images/javascript.svg" alt="javascript"> 
				<img src="images/jsp.svg" alt="jsp"> 
				<img src="images/mysql.svg" alt="mysql"> 
				<img src="images/responsivo.svg" alt="responsivo">
		</div>
	</div>
	<main>
		<div
			class="container rounded border border-success shadow p-3 mb-5 rounded">
			<form class="needs-validation" novalidate name="frmContato"
				action="update">


				<div class="form-group">
					<input type="text" name="id" class="form-control" readonly
						value="<%out.print(request.getAttribute("id"));%>">
				</div>
				<div class="form-group">

					<input type="text" name="nome"
						class="form-control border border-success" id="validationCustom01"
						value="<%out.print(request.getAttribute("nome"));%>" required>
					<div class="valid-feedback">Tudo certo!</div>
					<div class="invalid-feedback">Por favor, insira um nome.</div>
				</div>

				<div class="form-row">
					<div class="col-md-6 mb-3">
						<input type="text" name="telefone"
							class="form-control border border-success"
							id="validationCustom03"
							value="<%out.print(request.getAttribute("fone"));%>" required>
						<div class="valid-feedback">Tudo certo!</div>
						<div class="invalid-feedback">Por favor, insira um nome.</div>
					</div>

					<div class="col-md-6 mb-3">
						<input type="text" name="email"
							class="form-control border border-success"
							id="validationCustom04"
							value="<%out.print(request.getAttribute("email"));%>" required>
						<div class="valid-feedback">Tudo certo!</div>
						<div class="invalid-feedback">Por favor, insira um nome.</div>
					</div>

				</div>
				
				<button type="submit" class="btn badge badge-pill badge-primary">Salvar</button>
				
			</form>
		</div>
	</main>

	
	
	<script src="scripts/confirmar.js"></script>
	<script src="scripts/validador.js"></script>
	<script type="text/javascript" src="scripts/validar.js"></script>
</body>
</html>