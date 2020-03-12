<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

 <div class="jumbotron text-center">
               <h1>Make Your Own Cake</h1>
                <p>Hello Admin, View & manage the inventory of -  Make Your Own Cake!</p>

      </div>
<div class="container">

  <ul class="nav nav-tabs">
    <li class="active"><a data-toggle="tab" href="#home">Inventory</a></li>
    <li><a data-toggle="tab" href="#menu1">Manage Inventory</a></li>
    <li><a data-toggle="tab" href="#menu2">View your Orders</a></li>
    <li><a data-toggle="tab" href="#menu3">Popular Cakes</a></li>
    <li><a data-toggle="tab" href="#menu4">Most purchases</a></li>
  </ul>

  <div class="tab-content">
    <div id="home" class="tab-pane fade in active">
    <ul class="nav nav-pills nav-justified">
    <li><a href="/admin-view-orders"><button>Order List</button></a></li>

    </ul>
        <div style="text-align:center">
        <a href="/stocks"><button>Stock List</button></a>
        </div>
    </div>

    <div id="menu1" class="tab-pane fade">
    <ul class="nav nav-pills nav-justified">
	 <li><a href="/admin-orders">Click here.</a></li>

  </ul>
      <p>Check and monitor all the orders that is been placed.</p>
    </div>
    <div id="menu2" class="tab-pane fade">
     <ul class="nav nav-pills nav-justified">

     <li><a href="/admin-view-orders">Click here</a></li>

  </ul>
      <p>Check and monitor all the orders that is been placed.</p>
    </div>
    <div id="menu3" class="tab-pane fade">
   <ul class="nav nav-pills nav-justified">

     <li><a href="/popular">Click here</a></li>

  </ul>
      <p>Our daily menu features a wide variety of cakes and scratch baked confections in many traditional and modern flavors. We offer a rotation of seasonal goods, gift items, and feature a new flavor each week! Sweet delicacies and special occasion cakes for any event are available by custom order so give us a call and let us help with your celebration!</p>
    </div>
    <div id="menu4" class="tab-pane fade">
<ul class="nav nav-pills nav-justified">

     <li><a href="/purchases">Click here</a></li>
  </ul>
      <p>So whether a birthday, a dinner party, a wedding or shower, let us help you cater your next special event!</p>
    </div>
  </div>
</div>
</body>
</html>
