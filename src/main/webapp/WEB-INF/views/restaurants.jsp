<%@page import="java.util.Iterator"%>
<%@page import="com.tomato.spring.model.Rating"%>
<%@page import="java.util.List"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.tomato.spring.model.Restaurant" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<% ArrayList<Restaurant> listRestaurants = (ArrayList) request.getAttribute("listRestaurants");%>
<% ArrayList<Rating> ratings = (ArrayList) request.getAttribute("ratings");%>
<% Restaurant restaurant1 = (Restaurant) request.getAttribute("restaurant");%>


<html>
<head>
<title>Tomato</title>
</head>

<body>
 <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <style>
        body { padding-top:50px; }
    </style>
    <script type="text/javascript">
    function myFunction( A ) {
    	alert("String"+A);
        var x = document.getElementById('myTab');
            x.style.display = 'block';
        
    }
    function rateFunc(restname){
    	document.getElementById('restname').value = restname;
    	alert();
    	var x = document.getElementById('ratingView');
            x.style.display = 'block';
    }
    </script>
    
</head>
<body class="container">
    
    <div class="jumbotron">
         <h1>TOMATO !</h1>
    </div>
<br><br>

<form id="searchCriteria" action="/MyRestaurantReview/Restaurant/Search" method="post">
	<input id="Rest_ID" name="restId" type="hidden" value="1"/>
<table>
<tr>
		<td>Search Criteria::</td>
		<td>Food
		<select id="foodid" name="foodid" >
		    <option value="1">bad</option>
		    <option value="2">ok</option>
		    <option value="3">good</option>
		    <option value="4">great</option>
		    <option value="5">excellent</option>
		</select>
		</td>
		<td>Service
		<select id="servid" name="servid" >
		    <option value="1">bad</option>
		    <option value="2">ok</option>
		    <option value="3">good</option>
		    <option value="4">great</option>
		    <option value="5">excellent</option>
		</select>
		</td>
		<td>Ambiance
		<select id="ambid" name="ambid" >
		    <option value="1">bad</option>
		    <option value="2">ok</option>
		    <option value="3">good</option>
		    <option value="4">great</option>
		    <option value="5">excellent</option>
		</select>
		</td>
		
		<td colspan="2"><input type="submit" value="Search" />
	</tr>
	
</table>	
</form>

<%  if ( listRestaurants != null && !listRestaurants.isEmpty() ) { %>
	<table class="table table-bordered thead-default jumbotron">
	<tr>
		<!-- th width="80">ID</th-->
		<th width="120">Restaurant Name</th>
		<th width="120">Place</th>
		<th width= "120">Food</th>
		<th width= "120">Service</th>
		<th width= "120">Look And Feel</th>
		
	</tr>
	<% for (Restaurant restaurant : listRestaurants) { %>
		<tr>
			<!-- td><%= restaurant.getId() %></td-->
			<div  class="pager"><td> <a href="/MyRestaurantReview/view/<%= restaurant.getId() %>" onclick="rateFunc('<%= restaurant.getName() %>');"><%= restaurant.getName() %>(Click to view Ratings)</a></td></div>
			<td><%= restaurant.getAddress() %>,<%= restaurant.getCity() %></td>
			<td><%= restaurant.getAvgFood()%></td>
			<td><%= restaurant.getAvgServ() %></td>
			<td><%= restaurant.getAvgAmb() %></td>
			
		</tr>
		
	<%}%>
	
	</table>

	<% } %>
	<table id= "myTab" border="1" class="table table-striped jumbotron">
	
	<%  if ( ratings != null && !ratings.isEmpty() && restaurant1 != null) { %>
	
<div><th><h5><%= restaurant1.getName() %></h5></th></div>
	<tr>
		<!-- th width="80">ID</th-->
		<th width="120">Rating category</th>
		<th width="120">review</th>
		<th width= "120">rated</th>
		<th width= "120">user</th>
	</tr>
	<% for (Rating rating : ratings) { %>
		<tr>
			
			<td><%= rating.getName()%></td>
			<td><%= rating.getReview()%></td>
			<td><%= rating.getRating()%></td>
			<td><%= rating.getUserId()%></td>
			
		</tr>
		
	<%} } else{
	%>
	<tr>
	
	</tr>
	
</table>	

<%} %>
	

	</table>
	
	<% if (restaurant1 != null) { %> 
	
	<form id="ratingView" action="/MyRestaurantReview/Rating/add" method="post">
	<input id="Rest_ID" name="restId" type="hidden" value='<%= restaurant1.getId() %>'/>
<table>
<tr>
		<td>Your Name</td>
		<td><input id="uName"  required="required" name="uName" type="text" value=""/></td> 
	</tr>
	<tr>
		<td>look and feel</td>
		<td><input id="ambRating" required="required" name="ambRating" type="number" maxlength="1" value=""/></td> 
	</tr>
	<tr>
		<td>Food</td>
		<td><input id="foodRating" name="foodRating" required="required" type="number" value=""/></td> 
	</tr>
	<tr>
		<td>Service</td>
		<td><input id="serviceRating" name="serviceRating" required="required" type="number" value=""/></td> 
	</tr>
	<tr>
		<td>Review</td>
		<td><input id="review" name="review" required="required" type="text" value=""/></td> 
	</tr>
	
	<tr>
		<td colspan="2"><input type="submit" value="Add Rating" />
		</td>
	</tr>
</table>	
</form>
<% } %>

	
     <div class="featurette">
        <img class="featurette-image pull-right" src="http://getbootstrap.com/assets/img/examples/browser-icon-safari.png">
        <h2 class="featurette-heading">And lastly, this one. <span class="muted">Checkmate.</span></h2>
        <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
      </div>
    
      <div class="featurette">
        <img class="featurette-image pull-right" src="http://getbootstrap.com/assets/img/examples/browser-icon-safari.png">
        <h2 class="featurette-heading">And lastly, this one. <span class="muted">Checkmate.</span></h2>
        <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
      </div>
 <!-- FOOTER -->
      <footer>
        <p class="pull-right"><a href="#">Back to top</a></p>
        <p>© 2013 Company, Inc. · <a href="#">Privacy</a> · <a href="#">Terms</a></p>
      </footer>

    </div><!-- /.container -->
</body>
</html>
