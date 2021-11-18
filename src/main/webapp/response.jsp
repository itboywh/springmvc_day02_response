<%--
  Created by IntelliJ IDEA.
  User: 儒雅
  Date: 2021/11/13
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script>
        $(function () {
            $("#btn").click(function () {
               // alert("hello world");
                $.ajax({
                    url:"user/testAjax",
                    contentType:"application/json;charset=utf-8",
                    data:'{"username":"小明","password":"1223"}',
                    type:"post",
                    success:function(data){
                        alert(data);
                        alert(data.username);
                        alert(data.password);

                    }
                });
            });
        });
    </script>
</head>
<body>
<h3>Spring MVC响应方式</h3>
<a href="user/teststring">teststring</a><hr/>
<a href="user/testvoid">testvoid</a><hr/>
<a href="user/testModelAndView">testModelAndView</a><hr/>
<a href="user/testForwordorRedirect">testForwordorRedirect</a><hr/>
<button id="btn">测试json</button>
</body>
</html>
