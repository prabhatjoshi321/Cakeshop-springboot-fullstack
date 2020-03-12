$(document).ready(function(){
	$('#place-order').click(function(){
		orderCake();
	});
});

$("#resetBtn").click(function(){
	alert("hi");
});

function orderCake(){
		$.ajax({
		    url: 'localhost:8080/addProduct',
		    dataType: 'json',
		    type: 'GET',
		    contentType: 'application/json',
		    success: function (jsonData) {
	            window.location = '/orders';
	        },
	        error: function(data) {
	            console.log('Error loading the image');
	        }
	 } );
		    
	}