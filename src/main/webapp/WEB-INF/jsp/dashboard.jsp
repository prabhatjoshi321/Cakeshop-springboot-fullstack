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
                <p>Customize your cakes per your wish, we will ensure to fulfill your dream cake into reality as you dream of it!</p>
               
      </div>
<div class="container">

  <ul class="nav nav-tabs">
    <li class="active"><a data-toggle="tab" href="#home">Place your Order here</a></li>
    <li><a data-toggle="tab" href="#menu1">View your Orders</a></li>
  </ul>

  <div class="tab-content">
    <div id="home" class="tab-pane fade in active">
    <ul class="nav nav-pills nav-justified">
	 <li><a href="/order">Click here</a></li>
   
  </ul>
      <p>All of our products are made with high-quality ingredients and contain no preservatives. We don't use things that have long, hard-to-pronounce names like potassium sorbate and propylene glycol monoesters that are often found in baked goods. We use the good stuff like flour, sugar, and eggs.</p>
    </div>
    <div id="menu1" class="tab-pane fade">
     <ul class="nav nav-pills nav-justified">
	
     <li><a href="/orders">Click here</a></li>
   
  </ul>
      <p>Our cookies, rugelach, and raspberry bars get treated with the same amount of love and are crafted using high-quality ingredients and absolutely no preservatives. Our raspberry bars (a big customer favorite) contain fresh raspberries in their filling!</p>
    </div>
    <div id="menu2" class="tab-pane fade">
   <ul class="nav nav-pills nav-justified">

     <li><a href="/popular">Click here</a></li>

  </ul>
      <p>Our daily menu features a wide variety of cakes and scratch baked confections in many traditional and modern flavors. We offer a rotation of seasonal goods, gift items, and feature a new flavor each week! Sweet delicacies and special occasion cakes for any event are available by custom order so give us a call and let us help with your celebration!</p>
    </div>
    <div id="menu3" class="tab-pane fade">
<ul class="nav nav-pills nav-justified">

     <li><a href="/purchases">Click here</a></li>
  </ul>
      <p>So whether a birthday, a dinner party, a wedding or shower, let us help you cater your next special event!</p>
    </div>
  </div>
</div>
</body>
</html>