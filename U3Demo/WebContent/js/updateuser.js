$(document).ready(function() {
	var flag_nickname = false;
	var flag_phone = false;
	$("#nickName").blur(function(){
		if($("#nickName").val()){
			flag_nickname = true;
			$("#nickName").next().html("ok！").css("color","green");
		}else{
			$("#nickName").next().html("昵称不能为空！！").css("color","red");
		}
		
	});
	var reg = /^[1-9][0-9]{10}$/;
	$("#phoneNumber").blur(function(){
		if(reg.test($("#phoneNumber").val())){
			flag_phone = true;
			$("#phoneNumber").next().html("ok！").css("color","green");
		}else{
			$("#phoneNumber").next().html("手机号是11位数字！").css("color","red");
		}
		
	});
	
	
	
	$("form").submit(function(){
		if(!(flag_nickname)){
			if($("#nickName").val()){
				flag_nickname = true;
				$("#nickName").next().html("ok！").css("color","green");
			}else{
				$("#nickName").next().html("昵称不能为空！！").css("color","red");
			}
		}
		if(!(flag_phone)){
			if(reg.test($("#phoneNumber").val())){
				flag_phone = true;
				$("#phoneNumber").next().html("ok！").css("color","green");
			}else{
				$("#phoneNumber").next().html("手机号是11位数字！").css("color","red");
			}
		}
		return flag_nickname&&flag_phone;
		
	});
	
});