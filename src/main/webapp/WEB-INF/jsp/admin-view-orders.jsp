<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
<%@page session="false"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Make Your Order-admin</title>
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
		        <li><a href="/admin-dashboard">Homepage</a></li>
		      </ul>
		    </div>
		  </div>
		</nav>

	<form action="/getAllOrders">
           	    <div class="col col-md-12 seller-stock" style="padding-left:250px">
			            
			         <div class="col-sm-6 border-left seller-height">
			            <h2>All Orders</h2>
			            	 <table class="table table-striped" id="trending_products" style="width:750px">
			               <thead>
			                  <tr>
			                     <th scope="col">Cake Name</th>
			                     <th scope="col">Quantity</th>
			                     <th scope="col">Shipping Address</th>
			                     <th scope="col">Message</th>
			                     <th scope="col">Username</th>
			                     <th scope="col">Amount</th>
			                     <th scope="col">Edit</th>
			                     <th scope="col">Delete</th>
			                  </tr>
			               </thead>
			               <tbody id="top_products" >
			               		<c:out value="${fn:length(orders)}"/>
			               		
			               			<c:forEach var="orders" items="${orders}">
				               			<tr>
						               		<td class="prodAmt row"><c:out value="${orders.cakeName}"/></td>
						               		<td class="prodAmt row"><c:out value="${orders.qty}"/></td>
						               		<td class="prodAmt row"><c:out value="${orders.shippingAddress}"/></td>
						               		<td class="prodAmt row"><c:out value="${orders.message}"/></td>
						               		<td class="prodAmt row"><c:out value="${orders.username}"/></td>
						               		<td class="prodAmt row"><c:out value="${orders.amount}"/></td>
				               			</tr>
			               			</c:forEach>
			               </tbody>
			            </table>
			            
			          		
			         </div>
			         <hr />
			      </div>	
  </form>

</body>
</html>