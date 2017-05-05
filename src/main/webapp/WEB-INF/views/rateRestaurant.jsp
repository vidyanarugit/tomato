<%@page import="com.tomato.spring.model.Rating"%>
<%@ page import="java.util.ArrayList" %>

<% ArrayList<Rating> listRatings = (ArrayList) request.getAttribute("listRatings"); %>


<html>
<head>
	<title>Ratings of this Restaurant</title>
</head>
<body>



<br><br>
<h3></h3>

<%  if ( listRatings != null && !listRatings.isEmpty() ) { %>
	<table>
	<tr>
	<th width="120">restaurant name</th>
		<th width="120">rating</th>
		<th width="120">review</th>
		<th width="120">user</th>
	</tr>
	<% for (Rating rating : listRatings) { %>
		<tr>
			<td><%= rating.getName() %></td>
			<td><%= rating.getReview() %></td>
			<td><%= rating.getUserId() %></td>
			
		</tr>
	<%  } %>
	</table>
<% } %>

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
