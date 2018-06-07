<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Spring MVC CRUD pasantia</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container-fluid">
		<div class="row-fluid">
			<div class="col-md-6">
				<h4 class="text-center">Eliminar Pasantía</h4>
				<hr>
				<form:form method="post" servletRelativeAction="/admin/pasant/delete" modelAttribute="pasant">
					<form:hidden path="idpasantia" />
					<div class="form-group">
						<label for="idpasantia">Id: </label>
						<form:input path="idpasantia" class="form-control" readonly="true" />
					</div>
					<div class="form-group">
						<label for="ubicacion">Ubicación: </label>
						<form:input path="ubicacion" class="form-control" />
					</div>
					<div class="form-group">
						<label for="nombre_empresa">Nombre de la empresa: </label>
						<form:input path="nombre_empresa" class="form-control" />
					</div>
					<div class="form-group">
						<label for="alumno_idalumno">Id de Alumno: </label>
						<form:input path="alumno_idalumno" class="form-control" />
					</div>
					<div class="form-group">
						<label for="fecha">Fecha: </label>
						<form:input path="fecha" class="form-control" />
					</div>	
					<div class="form-group">
						<input type="submit" value="Delete" class="btn btn-success" />
						<a href="<%=request.getContextPath()%>/admin/pasant/list" class="btn btn-danger">Cancel</a>
					</div>
				</form:form>
			</div>
		</div>
	</div>


</body>
</html>