<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.css">
  
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.js"></script>
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
				<h4 class="text-center">Eliminar Ruta</h4>
				<hr>
				<form:form id="deleteForm" method="post" servletRelativeAction="/admin/routes/delete" modelAttribute="routes">
						<form:hidden path="idparadero" />
					<div class="form-group">
						<label for="id">Id: </label>
						<form:input id="txtParadero" path="idparadero" class="form-control" readonly="true" />
					</div>
					<div class="form-group">
						<label for="nombre">Nombre: </label>
						<form:input id="txtNombre" path="nombre" class="form-control" />
					</div>
					<div class="form-group">
						<label for="ubicacion">Ubicación: </label>
						<form:input id="txtUbicacion" path="ubicacion" class="form-control" />
					</div>
					<div class="form-group">
						<label for="horapartida">Hora de partida: </label>
						<form:input id="txtHorapartida" path="horapartida" class="form-control" type="time"/>
					</div>	
					<div class="form-group">
						<input type="submit" value="Delete" class="btn btn-success" />
						<a href="<%=request.getContextPath()%>/admin/routes/list" class="btn btn-danger">Cancel</a>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<script>
	$('#deleteForm').submit(function(event){
		event.preventDefault();
		var idparadero = $("#txtParadero").val();

		console.log(idparadero);
		$.ajax({
			type:"GET",
			data: JSON.stringify(obj),
			url: "https://ide50-sicked-sunday.cs50.io:8080/integrador-api/public/api/paradero/destroy/"+idparadero,
			contentType: "application/json",
			success: function(response){
				console.log("Exito");
				window.open('http://localhost:8081/gestion/admin/routes/list');
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