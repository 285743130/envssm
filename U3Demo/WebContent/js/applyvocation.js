$(document).ready(function() {
	var flag_beginDate = false;
	var flag_endDate = false;
	var flag_days = false;
	$("#beginDate").blur(function() {
		if ($("#beginDate").val()) {
			flag_beginDate = true;
			$("#beginDate").next().html("ok!").css("color", "green");
		} else {
			$("#beginDate").next().html("日期不能为空!").css("color", "red");
		}
	});
	$("#endDate").blur(function() {
		if ($("#endDate").val()) {
			flag_endDate = true;
			$("#endDate").next().html("ok!").css("color", "green");
		} else {
			$("#endDate").next().html("日期不能为空!").css("color", "red");
		}

	});
	var reg = /^[1-9][0-9]*$/;
	$("#days").blur(function() {
		if(reg.test($("#days").val())){
			flag_days = true;
			$("#days").next().html("ok！").css("color","green");
		}else{
			$("#days").next().html("当填写正确数据！").css("color","red");
		}
	});

	$("form").submit(function() {
		if(!(flag_beginDate)){
			if ($("#beginDate").val()) {
				flag_beginDate = true;
				$("#beginDate").next().html("ok!").css("color", "green");
			} else {
				$("#beginDate").next().html("日期不能为空!").css("color", "red");
			}
		}
		if(!(flag_endDate)){
			if ($("#endDate").val()) {
				flag_endDate = true;
				$("#endDate").next().html("ok!").css("color", "green");
			} else {
				$("#endDate").next().html("日期不能为空!").css("color", "red");
			}
		}
		if(!(flag_days)){
			if(reg.test($("#days").val())){
				flag_days = true;
				$("#days").next().html("ok！").css("color","green");
			}else{
				$("#days").next().html("当填写正确数据！").css("color","red");
			}
		}
		return flag_beginDate&&flag_endDate&&flag_days;
	});

});