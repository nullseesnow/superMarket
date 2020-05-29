<%@ page import="java.net.URLDecoder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>登录</title>

<%--    <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">--%>
    <meta http-equiv="refresh" content="IE=edge, chrome=1">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/res/static/login/css/login.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/res/static/login/js/jquery-1.8.0.min.js"></script>
    <script>
        function reurl() {

            url = location.href; //把当前页面的地址赋给变量 url

            var times = url.split("?"); //分切变量 url 分隔符号为 "?"

            if (times[1] != 1) { //如果?后的值不等于1表示没有刷新

                url += "?1"; //把变量 url 的值加入 ?1

                self.location.replace(url); //刷新页面

            }
        }

    </script>
</head>
<%
    String userName="";
    String userPwd="";
//遍历所有cookie
    Cookie[] cookies = request.getCookies();
    for(int i = 0; i <cookies.length ; i++) {
        if ("userName".equals(cookies[i].getName())){
            userName=cookies[i].getValue();
        }else if ("userPwd".equals(cookies[i].getName())){
            userPwd=cookies[i].getValue();
        }
    }
%>
<body class="login_bj"  onload="reurl()">
<div class="zhuce_body">
    <div class="zhuce_kong login_kuang">
    	<div class="zc">
        	<div class="bj_bai">
            <h3>登录</h3>
                <p style="color: red">${requestScope.msg1}</p>
       	  	  <form action="${pageContext.request.contextPath}/userTable/login1" method="post">
                <input name="userName" type="text" class="kuang_txt" placeholder="账户"  value="<%=URLDecoder.decode(userName, "UTF-8")%>">
                <input name="userPwd" type="password" class="kuang_txt" placeholder="密码" value="<%=URLDecoder.decode(userPwd, "UTF-8")%>">
                <div>
                    <a href="${pageContext.request.contextPath}/Page/login2">人脸登录</a>
                    <input type="checkbox" name="isLogin" id="save_me" value="y">
                    <label for="save_me">记住密码</label>
                </div>
                <input name="登录" type="submit" class="btn_zhuce" value="登录">
                
                </form>
            </div>
        	<div class="bj_right">
                <img src="${pageContext.request.contextPath}/res/static/img/xia.jpg" style="width:125px" height="175px"  >
                <p>还没有账号?<a href="${pageContext.request.contextPath}/Page/regist/#">立即注册</a></p>
            </div>
        </div>

    </div>

</div>
    
</body>
</html>