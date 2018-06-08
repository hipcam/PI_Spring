<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Spring MVC CRUD</title>
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
			<div class="col-md-4">
				<h4 class="text-center">User Login</h4>
				<hr>
				<form:form id="loginForm" method="post" action="login">
					<div class="form-group">
						<label for="login">Login: </label>
						<form:input id="txtLogin" path="login" class="form-control" />
					</div>
					<div class="form-group">
						<label for="password">Password: </label>
						<form:input id="txtpass" path="password" class="form-control" />
					</div>
					<div class="form-group">
						<input type="submit" value="Login" class="btn btn-success" />
					</div>
				</form:form>
				
			</div>
		</div>
	</div>
	
	<script>
	$('#loginForm').submit(function(event){
		event.preventDefault();
		var login = $("#txtLogin").val();
		var password = $("#txtpass").val();
	

		var obj ={
				"login": login,
				"password": password
		};
		console.log(obj);
		$.ajax({
			type:"POST",
			data: JSON.stringify(obj),
			url: "https://tecsup-cloned-sicked-sunday.c9users.io:8080/integrador-api/public/api/login",
			contentType: "application/json",
			success: function(response){
				console.log("Exito");
				window.open('http://localhost:8081/gestion/admin/menu');
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
