$(document).ready(
	
		function() {
			 $.ajaxSetup({  
				    async : false  //ajax是异步执行的，该方法设置ajax为同步
				}); 
			var $username = $("form [name= 'name']");
			var $passWord = $("form [name= 'password']");
			var $flag_name = false;
			var $flag_pwd = false;
			$username.blur(function() {
				
				if ($username.val() == "" || $username.val() == null) {
					$("#message").html("用户名不能为空!");
				} else {
					$flag_name = true;
				}
			});
			$passWord.blur(function() {
				if ($passWord.val() == "" || $passWord.val() == null) {
					$("#message").html("密码不能为空!");
					
				} else if ($passWord.val() != "" || $passWord.val() != null) {
					$flag_pwd = true;
				}

			});
			$("form").submit(
					function() {
						if ($username.val() == "" || $username.val() == null) {
							
						} else {
							$flag_name = true;
						}
						if ($passWord.val() == "" || $passWord.val() == null) {
						
							
						} else if ($passWord.val() != "" || $passWord.val() != null) {
							$flag_pwd = true;
						}
						if(!($flag_name&&$flag_pwd)){
							$("#message").html("用户名和密码不能为空!");
						}
						return $flag_name&&$flag_pwd;
				});
		});
