<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
<div style="text-align: center">
  <form action="login" method="post" id="loginForm">
    用户:<input type="text" name="uname" id="uname" value="${messageModel.objet.userName}"> <br>
    密码:<input type="password" name="upwd" id="upwd" value="${messageModel.objet.userPwd}"> <br>
    <span id="msg" style="font-size: 12px;color: red">${messageModel.msg}</span><br>
    <button type="button" id="loginBtn">登录</button>
    <button type="button">注册</button>
  </form>
</div>
</body>
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
  <script type="text/javascript">
    $("#loginBtn").click(function(){
      //获得用户姓名和密码
      var uname = $("#uname").val();

      var upwd = $("#upwd").val();

      if(isEmpty(uname)){
        $("#msg").html("用户姓名不可为空！");
        return;
     }
      if(isEmpty(upwd)){
        $("#msg").html("用户密码不可为空！");
        return;
     }
        $("#loginForm").submit();
    });
    //判断字符串是否为空
    function isEmpty(str) {
      is(str == null || str.trim( == "") {
        return true;
      }
      return false;
    }

  </script>
</html>
