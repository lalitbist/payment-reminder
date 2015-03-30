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
				contentType : "application/json; charset=utf-8",
				dataType : "json",
				data : JSON.stringify(user)
			});

			ajaxCall.done(function(data) {
				alert("Welcome! " + data.username);
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