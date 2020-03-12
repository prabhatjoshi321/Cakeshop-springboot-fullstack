<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
<%@page session="false"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Make Your Order</title>
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
      <script src="https://code.jquery.com/jquery-2.2.4.min.js" integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44=" crossorigin="anonymous"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
 <div class="jumbotron text-center">
               <i class="fa fa-birthday-cake" style="font-size:48px;"></i><h1>Make Your Own Cake</h1>
      </div>
      
      <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">Make Your Own Cake</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="/purchases">Top Purchaser</a></li>
        <li><a href="/admin-orders">View Orders</a></li>
        <li><a href="/popular">Top Purchases</a></li>
         <li><a href="/order">Place Order</a></li>
      </ul>
    </div>
  </div>
</nav>

	 	
			               			<%-- <c:forEach var="popularUsers" items="${popularUsers}">
				               			<tr>
						               		<td class="productName"><c:out value="${orders.cakeName}"/></td>
						               		<td class="prodAmt row"><c:out value="${orders.username}"/></td>
						               		<td class="prodAmt row"><c:out value="${orders.cid}"/></td>
				               			</tr>
			               			</c:forEach> --%>
			               			
			       
			            <h2>Popular cakes</h2>
			             <table class="table table-striped" id="trending_products">
			               <thead>
			                  <tr>
			                     <th scope="col">Cake Name</th>
			                     <th scope="col">CID</th>
			                  </tr>
			               </thead>
			               <tbody id="top_products">
			               		<c:out value="${fn:length(popularUsers)}"></c:out>
			               			<c:forEach var="popularUsers" items="${popularUsers}">
			               			
				               			<tr>
						               		<td class="prodAmt row"><c:out value="${popularUsers.username}"/></td>
				               			</tr>
			               			</c:forEach>
			               	</tbody>
			               	</table>		
			        
</body>
</html>