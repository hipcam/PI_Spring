<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Spring MVC CRUD-pasantia</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script
        src="https://code.jquery.com/jquery-3.2.1.min.js"
        integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
        crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.css">
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.js"></script>
</head>
<body>
<div class="container-fluid">
		<div class="row-fluid">
			<div class="col-md-6">
				<h4 class="text-center">Crear Pasantía</h4>
				<hr>
				<form:form id="createForm" method="post" action="create" modelAttribute="pasant">
					<form:hidden path="idpasantia" />
					<div class="form-group">
						<label for="idpasantia">Id: </label>
						<form:input path="idpasantia" class="form-control" readonly="true" />
					</div>
					<div class="form-group">
						<label for="ubicacion">Ubicación: </label>
						<form:input id="txtUbicacion" path="ubicacion" class="form-control" />
					</div>
					<div class="form-group">
						<label for="nombre_empresa">Nombre de la empresa: </label>
						<form:input id="txtNombreEmp" path="nombre_empresa" class="form-control" />
					</div>
					<div class="form-group">
						<label for="alumno_idalumno">Id de Alumno: </label>
						<form:input id="txtAlumnoId" path="alumno_idalumno" class="form-control" />
					</div>
					<div class="form-group">
						<label for="fecha">Fecha: </label>
						<form:input id="txtFecha" path="fecha" class="form-control" />
					</div>	
					<div class="form-group">
						<input type="submit" value="Create" class="btn btn-success" />
						<a href="<%=request.getContextPath()%>/admin/pasant/list" class="btn btn-danger">Cancel</a>
					</div>
				</form:form>
			</div>
		</div>
	</div>
<script>
$('#createForm').submit(function(event){
	event.preventDefault();
	var ubicacion = $("#txtUbicacion").val();
	var nombre_empresa = $("#txtNombreEmp").val();
	var idalumno = $("#txtAlumnoId").val();
	var inicio = $("#txtFecha").val();
	
	var obj ={
			
			"ubicacion": ubicacion,
			"nombre_empresa": nombre_empresa,
			"idalumno": idalumno,
			"inicio": inicio
	};
	console.log(obj);
	$.ajax({
		type:"POST",
		data: JSON.stringify(obj),
		url: "https://ide50-sicked-sunday.cs50.io:8080/integrador-api/public/api/pasantia/store",
		contentType: "application/json",
		success: function(response){
			console.log("Exito");
			window.open('http://localhost:8081/gestion/admin/pasant/list');
			//table.ajax.reload();
			//table.draw();
			//$('#modalNuevo').modal('hide');
			 // window.location = "localhost:8081/gestion/admin/routes/list";
		}
	}).fail(function($xhr){
		var data = $xhr.responseJSON;
	});
});
</script>

</body>
</html>