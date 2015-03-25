$(document).ready(function() {
	$("#registerForm").submit(function(e) { // loginForm is submitted
		var username = $('#username').val(); // get username
		var password = $('#password').val(); // get password
		var firstname = $('#firstName').val();
		var lastname = $('#lastName').val();
		var email = $('#email').val();
		if (username && password) { // values are not empty
			var user = new Object();
			user.username = username;
			user.password = password;
			user.firstName = firstname;
			user.lastName = lastname;
			user.email = email;
			var ajaxCall = $.ajax({
				type : "POST",
				url : "/users", // URL to save user
				contentType : "application/json; charset=utf-8",
				dataType : "json",
				data : JSON.stringify(user)
			});

			ajaxCall.done(function(data) {
				alert("Welcome! " + data.username);
				//return true;
			});

			ajaxCall.fail(function(jqXHR, textStatus) {
				alert("Failed" + textStatus);
				//return false;
			});
		} else {
			alert("fields are empty");
		}
		e.preventDefault(); // STOP default action
		///return false;
	});

});