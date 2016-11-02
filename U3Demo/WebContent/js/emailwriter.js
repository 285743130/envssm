$(document).ready(function() {
	
	var flag_title = false;
	var flag_upfile = false;
	$("#title").blur(function() {
		if ($("#title").val()) {
			flag_title = true;
			$("#title").next().html("ok!").css("color", "green");
		} else {
			$("#title").next().html("标题不能为空!").css("color", "red");
		}

	});
	$("#upfile").change(function checkfile() {
		var oFile = document.getElementById("upfile").files[0]; 
		if(oFile){
		    if (oFile.size > 9437184 ){// 9 mb for bytes.
	        	$("#upfile").next().html("文件不能大于9M!").css("color", "red");
	           
	        }else{
	        	flag_upfile = true;
	        	$("#upfile").next().html("ok!").css("color", "green");
	        }
		}else{
			$("#upfile").next().html("文件不能为空!").css("color", "red");
		}
    
	});

	$("form").submit(function() {
		if(!(flag_title)){
			if ($("#title").val()) {
				flag_title = true;
				$("#title").next().html("ok!").css("color", "green");
			} else {
				$("#title").next().html("标题不能为空!").css("color", "red");
			}
		}
		
		if(!(flag_upfile)){
			var oFile = document.getElementById("upfile").files[0]; 
			if(oFile){
			    if (oFile.size > 9437184 ){// 9 mb for bytes.
		        	$("#upfile").next().html("文件不能大于9M!").css("color", "red");
		           
		        }else{
		        	flag_upfile = true;
		        	$("#upfile").next().html("ok!").css("color", "green");
		        }
			}else{
				$("#upfile").next().html("文件不能为空!").css("color", "red");
			}
		}
		
		return flag_title && flag_upfile;

	});

});