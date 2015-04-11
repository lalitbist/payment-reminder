$(document).ready(function() {
	$("#loginForm").submit(function(e) { // loginForm is submitted
		var username = $('#username').val(); // get username
		var password = $('#password').val(); // get password

		if (username && password) { // values are not empty
			var user = new Object();
			user.email = username;
			user.password = password;
			var ajaxCall = $.ajax({
				type : "POST",
				url : "/login", // URL of the login
				contentType : "application/x-www-form-urlencoded",
				//dataType : "json",
				data : user
			});

			ajaxCall.done(function(data) {
				if(data.error){
					alert("Error While Login : " + data.error);
				}else if(data.redirect){
					window.location.href = data.redirect;
				}
			});

			ajaxCall.fail(function(jqXHR, textStatus) {
				alert("Failed" + textStatus)
			});
		} else {
			alert("fields are empty");
		}
		e.preventDefault(); // STOP default action
	});

});