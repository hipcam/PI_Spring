<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Spring MVC CRUD buses</title>
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
<br>
<br>
    <div class="container">
      <!-- Static navbar -->
      <nav class="navbar navbar-default">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
   <div align="left">
	<img src="http://www.masgamers.com/wp-content/uploads/2016/01/Logo_6577471.png" width="350" >
</div>.        
          </div>
          <div id="navbar" class="navbar-collapse collapse">
   
            <ul class="nav navbar-nav navbar-right">
              <li class="active"><a href="">Buses <span class="sr-only">(current)</span></a></li>
              <li><a href="<%=request.getContextPath()%>/admin/routes/list">Rutas</a></li>
              <li><a href="<%=request.getContextPath()%>/admin/pasant/list">Pasantías</a></li>
              <li><a href="<%=request.getContextPath()%>/admin/analisis/maps">Análisis</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </nav>
	<div class="container">
			<div class="table-wrapper">
				 <div class="table-title">
                <div class="row">
                    <div class="col-sm-6">
						<h2>Administración  <b>Buses</b></h2>
					</div>
				
                </div>
            </div>
				<table id="tablabuses"class="table table-striped table-hover">
					<thead>
						<tr>
							<th>ID</th>
							<th>Placa</th>
							<th>Opciones</th>
						
						</tr>
					</thead>
					<tbody>

					</tbody>
				</table>
				<br /> 
				<a href="<%=request.getContextPath()%>/admin/buses/createform"
					class="btn btn-success"><i class="glyphicon glyphicon-edit"></i>
					Nuevo Bus</a>
					<a href="<%=request.getContextPath()%>/admin/menu"
					class="btn btn-primary"><i class="glyphicon glyphicon-edit"></i>
					Menu</a> 
			</div>
		</div>
		</div>
		<script>
	$(document).ready(function(){
		var table = $('#tablabuses').DataTable({
			"ajax": {
				"url": "https://tecsup-cloned-sicked-sunday.c9users.io:8080/integrador-api/public/api/bus",
			},
			"columns":[
				{
					"data": "idbus"
				},
				{
					"data": "placa"
				}
			],
			
			rowId: 'idbus',
			"columnDefs": [{
				"targets":2,
				"data": null,
				"defaultContent": "<button type='button'  id='btnEditar' class='btn btn-warning btn-circle'><i class='glyphicon glyphicon-edit'></i></button>"+
				"<button type='button' id='btnEliminar' class='btn btn-danger btn-circle' data-toggle='#modal' data-target='#modalEditar'><i class='glyphicon glyphicon-trash'></i></button>"
			}],
			responsive: true
		});

	});
	</script>
</body>
</html>
