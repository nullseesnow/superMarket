<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/static/css/public.css"/>
</head>
<body>
<!--头部-->
    <header class="publicHeader">
        <h1>超市账单管理系统</h1>
        <div class="publicHeaderR">
            <p><span>下午好！</span><span style="color: #fff21b"> ${sessionScope.userName}</span> , 欢迎你！</p>
            <a href="${pageContext.request.contextPath}/Page/login3">退出</a>
        </div>
    </header>
<!--时间-->
    <section class="publicTime">
        <span id="time">2015年1月1日 11:11  星期一</span>
        <a href="${pageContext.request.contextPath}/res/static/#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
    </section>
<!--主体内容-->
    <section class="publicMian ">
        <div class="left">
            <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
            <nav>
                <ul class="list">

                    <li><a href="${pageContext.request.contextPath}/Page/providerList">供应商管理</a></li>
                    <li><a href="${pageContext.request.contextPath}/Page/userList">用户管理</a></li>
                    <li><a href="${pageContext.request.contextPath}/Page/shopList">商品管理</a></li>
                    <li><a href="${pageContext.request.contextPath}/Page/password">密码修改</a></li>
                    <li><a href="${pageContext.request.contextPath}/userTable/clearCookie1">退出系统</a></li>
                </ul>
            </nav>
        </div>
        <div class="right">
           公共页面
        </div>
    </section>
    <footer class="footer">
    </footer>
<script src="${pageContext.request.contextPath}/res/static/js/time.js"></script>

</body>
</html>