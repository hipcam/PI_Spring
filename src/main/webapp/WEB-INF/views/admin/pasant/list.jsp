<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Spring MVC CRUD pasantias</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon" href="https://img11.androidappsapk.co/300/7/e/4/edu.tecsup.activity.png">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://getbootstrap.com/docs/3.3/dist/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
              <li><a href="<%=request.getContextPath()%>/admin/menu">Buses <span class="sr-only">Buses</span></a></li>
              <li><a href="<%=request.getContextPath()%>/admin/routes/list">Rutas</a></li>
              <li class="active"><a href="">Pasantía<span class="sr-only">(current)</span>s</a></li>
              <li><a href="<%=request.getContextPath()%>/admin/analisis/list">Análisis</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </nav>
	<div class="container">
			<div class="table-wrapper">
				 <div class="table-title">
                <div class="row">
                    <div class="col-sm-6">
						<h2>Administración  <b>Pasantías</b></h2>
					</div>
				
                </div>
            </div>				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>ID</th>
							<th>Ubicación</th>
							<th>Nombre de la empresa</th>
							<th>Id de Alumno</th>
							<th>Fecha</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="pas" items="${pasantias}">
							<tr>
								<td>${pas.idpasantia}</td>
								<td>${pas.ubicacion}</td>
								<td>${pas.nombre_empresa}</td>
								<td>${pas.alumno_idalumno}</td>
								<td>${pas.fecha}</td>
								<td><a
									href="<%=request.getContextPath()%>/admin/pasant/editform/${pas.idpasantia}"
									class="btn btn-info btn-xs"> <i
										class="glyphicon glyphicon-check"></i>Edit
								</a></td>
								<td><a
									href="<%=request.getContextPath()%>/admin/pasant/deleteform/${pas.idpasantia}"
									class="btn btn-danger btn-xs"> <i
										class="glyphicon glyphicon-trash"></i> Delete
								</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<br /> <a href="<%=request.getContextPath()%>/admin/pasant/createform"
					class="btn btn-success"><i class="glyphicon glyphicon-edit"></i>
					Nueva Pasantía</a>
					<a href="<%=request.getContextPath()%>/admin/menu"
					class="btn btn-primary"><i class="glyphicon glyphicon-edit"></i>
					Menu</a>
			</div>
			<font color="red">${message}</font>
		</div>
	</div>
</body>
</html>
