<!DOCTYPE html>
<html>
  <head>
<script
        src="https://code.jquery.com/jquery-3.2.1.min.js"
        integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
        crossorigin="anonymous"></script>
    <style>
      /* Always set the map height explicitly to define the size of the div
       * element that contains the map. */
      #map {
        height: 100%;
      }
      /* Optional: Makes the sample page fill the window. */
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
    </style>
  </head>
  <body>
    <div id="map"></div>
    <script>
      function initMap() {
    	      	 $.get({url: "http://tecsup-cloned-sicked-sunday.cs50.io:8080/integrador-api/public/api/alumnos/posiciones", crossDomain: true, dataType:'json' ,success: function(data){
    	console.log("inside get");
           var splitted = data[0]["ubicacion"].split(" ");
			var center = {lat: parseFloat(splitted[0]), lng: parseFloat(splitted[1])};
    		var map = new google.maps.Map(document.getElementById('map'), {
    	          zoom: 14,
    	          center: center
    	        });
    		new google.maps.Marker({
  	          position: center,
  	          map: map
  	        });
    		var markers = [];
    		for(let i = 0 ; i < data.length ; i++){
    			if(data[i]["ubicacion"] === null){
    				continue;
    			}
    			var splitted = data[i]["ubicacion"].split(" ");
    			var markerx = new google.maps.Marker({
      	          position: {lat: parseFloat(splitted[0]), lng: parseFloat(splitted[1])},
      	          map: map
      	        });
    			markers.push(markerx);
    		}
    		console.log(markers.length);
    		var markerCluster = new MarkerClusterer(map, markers,
    	            {imagePath: 'https://developers.google.com/maps/documentation/javascript/examples/markerclusterer/m'});
    	      
    	 }});
      }
    		
    
    </script>
     <script src="https://developers.google.com/maps/documentation/javascript/examples/markerclusterer/markerclusterer.js">
    </script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAp1D7HNtzB4yKzA2MxuO--TswBuBPhlw0&callback=initMap">
    </script>
  </body>
</html>