<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="loginpanelwrap">
<div>
             <div>登录</div>
         </div>
         <form action="api/user/login">
             <div>
                 <div>
                     <label>用户名:</label>
                     <input type="text" name="username" />
                 </div>
             </div>
             <div>
                 <label>密码：</label>
                 <input type="password" name="password" />
             </div>
             <div>
                 <label>验证码:</label>
                 <input type="text" name="VerificationCode"/>
                 <img id="validationCode_img"  src="api/Verification" onclick="myReload()">
             </div>
             <div>
                 <span></span>
                 <input type="submit" id="loginform_submit" value="登录" />
             </div>
         </form>
         <script type="text/javascript">
    function myReload() {
        document.getElementById("validationCode_img").src ="api/Verification?"+Math.random();
    }
</script>
     </div>
 </body>
</html>