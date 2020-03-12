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
		        <li><a href="/admin-view-orders">View Orders</a></li>
	
		      </ul>
		    </div>
		  </div>
		</nav>
      
	 		<form action="/addCake" class="modal-content animate" style="padding-left:150px; padding-right:150px; padding-top:100px; padding-bottom:100px" method="POST" enctype="multipart/form-data">
	 		
	 		<div class="form-group">
                     <label for="cakeImage">cake picture:</label>
                      <input type="file" required class="form-control" id="cakeImage" placeholder="Select image" name="photo" size="50">
                  </div>
                  <div class="form-group">
                     <label for="cakeName">cakeName:</label>
                      <input type="text" required class="form-control" id="cakeName" placeholder="Enter cake name" name="cakeName">
                  </div>
                
                  <div class="form-group">
                     <label for="stock">Stock:</label>
                     <input type="text" required class="form-control" id="stock" placeholder="Enter the stock" name="stock">
                  </div>
                   <div class="form-group">
                     <label for="type">Type:</label>
                     <input type="text" required class="form-control" id="type" placeholder="Enter the type of cake most suitable for" name="type">
                  </div>
                  <div class="form-group">
                     <label for="amount">Amount:</label>
                     <input type="text" required class="form-control" id="amount" placeholder="Enter the amount" name="amount">
                  </div>
                  <div class="col-md-12 text-center"> 
                     <button id="place-order" name="place-order" class="btn btn-primary">Submit</button> 
                  </div>
           </form>
           

</body>
</html>