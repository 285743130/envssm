$(document).ready(function() {
	var flag_name = false;
	var flag_nickName = false;
	var flag_password= false;
	var flag_phoneNumber= false;
	$("#name").blur(function() {
		if ($("#name").val()) {
			flag_name = true;
			$("#name").next().html("ok!").css("color", "green");
		} else {
			$("#name").next().html("用户名不能为空!").css("color", "red");
		}

	});
	$("#nickName").blur(function() {
		if ($("#nickName").val()) {
			flag_nickName = true;
			$("#nickName").next().html("ok!").css("color", "green");
		} else {
			$("#nickName").next().html("用户名不能为空!").css("color", "red");
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
	var reg = /^[1-9][0-9]{10}$/;
	$("#phoneNumber").blur(function(){
		if(reg.test($("#phoneNumber").val())){
			flag_phoneNumber = true;
			$("#phoneNumber").next().html("ok！").css("color","green");
		}else{
			$("#phoneNumber").next().html("手机号是11位数字！").css("color","red");
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
		if(!(flag_name)){
			if ($("#nickName").val()) {
				flag_nickName = true;
				$("#nickName").next().html("ok!").css("color", "green");
			} else {
				$("#nickName").next().html("用户名不能为空!").css("color", "red");
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
		if(!(flag_phoneNumber)){
			if(reg.test($("#phoneNumber").val())){
				flag_phoneNumber = true;
				$("#phoneNumber").next().html("ok！").css("color","green");
			}else{
				$("#phoneNumber").next().html("手机号是11位数字！").css("color","red");
			}
		}
		return flag_name && flag_password && flag_nickName &&flag_phoneNumber;

	});
	
	
});