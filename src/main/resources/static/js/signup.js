/**
 * 
 */
$(document).ready(function(){
	$("#signup-submit").click(function(){
		registerUser();
	});
});

$("#resetBtn").click(function(){
	alert("hi");
});

function registerUser(){
	$.ajax({
	    url: 'localhost:8080/signup',
	    dataType: 'json',
	    type: 'GET',
	    contentType: 'application/json',
	    success: function (jsonData) {
            window.location = '/login';
        },
        error: function(data) {
            console.log('Error loading the image');
        }
 } );
	    
}
