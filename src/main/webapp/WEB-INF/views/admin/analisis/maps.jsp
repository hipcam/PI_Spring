<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <style>
       #map {
        height: 400px;
        width: 100%;
       }
    </style>
    <script
        src="https://code.jquery.com/jquery-3.2.1.min.js"
        integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
        crossorigin="anonymous"></script>
  </head>
  <body>
    <h3>Alertfiy Web</h3>
    <div id="map"></div>
    <script>
      function initMap() {
 
//aquí direccionas al route
 $.ajax({url: "../alert--web/alert/alertifyweb/index.php/markers",method: "GET", async:false, dataType: "JSON",success: function(data){
// imprime en consola el dato con JSON.stringify(data) para ver qué se obtiene y partir de ello ve cómo manipular la data
          alert();
           var uluru = {lat: -25.363, lng: 131.044};
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 4,
          center: uluru
        });
        var marker = new google.maps.Marker({
          position: uluru,
          map: map
        });
        //SE CREAN LOS PUNTOS EN EL MAPA CON LAS COORDENADAS DEL JSON
           for(var i = 0 ; i < data.length ; i++){
            var splitted = data[i][1].split(" ");
          var markerx = new google.maps.Marker({
          position: {lat: parseFloat(splitted[0]), lng: parseFloat(splitted[1])},
          //SE INSERTAN EN EL MAPA
          map: map
        });
        

      }
        alert(JSON.stringify(data));

      }});

}
//abajo en el script último dice .../js?key=... si la llave no funciona generas una en google maps javascript web api
   </script> 
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAPJ0J5EhKUiXg12ZOOGTr7KHU7iELeAiQ&callback=initMap">
    </script>
  </body>
</html>