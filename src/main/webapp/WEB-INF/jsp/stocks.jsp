<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Stocks</title>
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

	<form action="/getAllCakes">
           	    <div class="col col-md-12 seller-stock" style="padding-left:250px">

			         <div class="col-sm-6 border-left seller-height" style="text-align:center">
			            <h2>Stocks</h2>
			            	 <table class="table table-striped" id="stock-list" style="width:750px">
			               <thead>
			                  <tr>
			                     <th scope="col">Image</th>
                           <th scope="col">Cake Name</th>
			                     <th scope="col">Stock</th>
			                     <th scope="col">Amount</th>
			                     <th scope="col">Type</th>
			                     <th scope="col">Edit</th>
			                     <th scope="col">Delete</th>
			                  </tr>
			               </thead>
			               <tbody id="stock-list" >
			               		<c:out value="${fn:length(cake)}"/>

			               			<c:forEach var="Cake" items="${cakes}">
				               			<tr>
						               		<td class="prodAmt row"><c:out value="${cakes.imageStream}"/></td>
						               		<td class="prodAmt row"><c:out value="${cakes.cakeName}"/></td>
						               		<td class="prodAmt row"><c:out value="${cakes.stock}"/></td>
						               		<td class="prodAmt row"><c:out value="${cakes.amount}"/></td>
						               		<td class="prodAmt row"><c:out value="${cakes.type}"/></td>
				               			</tr>
			               			</c:forEach>
			               </tbody>
			            </table>

                  <label><button>Add New Entry</button></label>


			         </div>
			         <hr />
			      </div>
  </form>

</body>
</html>
