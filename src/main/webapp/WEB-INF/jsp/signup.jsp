<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Registration</title>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
      <script src="https://code.jquery.com/jquery-2.2.4.min.js" integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44=" crossorigin="anonymous"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
      <link rel="stylesheet" href="css/login.css">
      <link rel="stylesheet" href="css/dashboard.css">
      <script src="js/login.js"></script>
      <script src="js/signup.js"></script>
   </head>
   <body>
      <div class="seller-header">
         <div class="seller-container">
            <nav class="seller-nav">
               <span class="seller-heading">Make Your Own Cake</span>               
            </nav>
         </div>
      </div>
      <div class="container signup-form">
         <h4 class="registration-heading">Please complete the registration to login!</h4>
         <div class="panel panel-default">
            <div class="panel-body">
               <form action="/signup" method="POST">
                  <div class="form-group">
                     <label for="emailId">Username:</label>
                     <input type="email" required class="form-control" id="emailId" placeholder="Enter your email" name="emailId">
                  </div>
                  <div class="form-group">
                     <label for="password">Password:</label>
                     <input type="password" required class="form-control" id="password" placeholder="Enter password" name="password">
                  </div>
                  <div class="form-group">
                     <label for="firstname">Name:</label>
                     <input type="text" required class="form-control" id="firstname" placeholder="Enter your full name" name="firstname">
                  </div>
                   <div class="form-group">
                     <label for="dob">DOB:</label>
                     <input type="text" required class="form-control" id="dob" placeholder="dd/MM/yyyy" name="dob">
                  </div>
                 <!--  <div class="form-group">
                     <label for="lastname">LastName:</label>
                     <input type="text" required class="form-control" id="lastname" placeholder="Enter lastname" name="lastname">
                  </div> -->
                  <div class="form-group">
                     <label for="phone">Phone:</label>
                     <input type="tel" required class="form-control" id="phone" placeholder="Enter phone number" name="phone">
                  </div>
                  <div class="form-group">
                     <label for="address">Address:</label>
                     <input type="text" required class="form-control" id="address" placeholder="Enter your address" name="address">
                  </div>
                  <div>
                  	<label path = "role">Role</label>
                  	<INPUT TYPE="radio" name="role" value="admin"/>Admin
					<INPUT TYPE="radio" name="role" value="user"/>User
                  </div>
                  <div class="col-md-12 text-center"> 
                     <button id="signup-submit" name="signup-submit" class="btn btn-primary">Register</button> 
                  </div>
               </form>
            </div>
         </div>
      </div>
   </body>
</html>