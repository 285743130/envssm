$(document).ready(function() {
	var flag_name = false;
	var flag_password = false;
	$("#name").blur(function() {
		if ($("#name").val()) {
			flag_name = true;
			$("#name").next().html("ok!").css("color", "green");
		} else {
			$("#name").next().html("用户名不能为空!").css("color", "red");
		}

	});
	$("#password").blur(function() {
		if ($("#password").val()) {
			flag_password = true;
			$("#password").next().html("ok!").css("color", "green");
		} else {
			$("#password").next().html("密码不能为空!").css("color", "red");
		}

	});
	$("form").submit(function() {
		if(!(flag_name)){
			if ($("#name").val()) {
				flag_name = true;
				$("#name").next().html("ok!").css("color", "green");
			} else {
				$("#name").next().html("用户名不能为空!").css("color", "red");
			}
		}
		
		if(!(flag_password)){
			if ($("#password").val()) {
				flag_password = true;
				$("#password").next().html("ok!").css("color", "green");
			} else {
				$("#password").next().html("密码不能为空!").css("color", "red");
			}
		}
		
		return flag_name && flag_password;

	});
	
});