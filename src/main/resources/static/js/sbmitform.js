$(document).ready(function(){
	$("#submit").click(function(){
		
	
	$post("signup/savedata",
			{
				name:	$("#name").val(),
				emailid: $("#emailid").val(),
				password: $("#password").val()
			}, 
			function(data){
				alert(data);
			});
	});
});
