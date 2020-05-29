<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/static/css/public.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/static/css/style.css"/>
    <script src="${pageContext.request.contextPath}/res/static/js/jquery-1.9.1.min.js"></script>
    <script>
        //使用ajax来判断旧密码与数据库中的密码是否一致
        $(function(){
            //先写一个鼠标移开的事件
            $('#oldpwd').blur(function(){
                var oldpwd = $('#oldpwd').val();//获取文本框的值
                // alert(oldpwd)
                $.ajax({
                    type : "post",//post的提交方式
                    url :${pageContext.request.contextPath}"/userTable/selectByExample3",//完整的路
                    datatype:"json",
                    data : {//获取旧的密码和跳转到servlet文件的方法名
                        "oldpwd" : oldpwd
                    },
                    success : function(data) {//成功的话判断密码是否为数据库中的密码
                        if (data.code==200) {//如果为true则输入正确
                            $('#oldpwd2').text('输入正确');
                            document.getElementById('newpwd').style.display=""
                            document.getElementById('renewpwd').style.display=""
                            document.getElementById('n').style.display=""
                            document.getElementById('r').style.display=""
                        } else {//判断是否为空
                            if (oldpwd == "" || oldpwd == null) {
                                $('#oldpwd2').text('旧密码不能为空');
                            } else {
                                $('#oldpwd2').text('密码输入不正确');
                                document.getElementById('sub').style.display="none"
                            }
                        }
                    },
                    error : function() {
                        //alert("失败");
                    }
                });
            })
            $('#newpwd').blur(function () {
                var newpwd = $('#newpwd').val();

                if (newpwd == "" || newpwd == null){
                    $('#newpwd2').text('新密码不能为空')
                    document.getElementById('sub').style.display="none"
                }else {
                    $('#newpwd2').text('新密码可用')
                }
            })
            $('#renewpwd').blur(function () {
                var newpwd = $('#newpwd').val();
                var renewpwd = $('#renewpwd').val();

                if (renewpwd == "" || renewpwd  == null){
                    $('#renewpwd2').text('新密码不能为空')
                    document.getElementById('sub').style.display="none"
                }else if (renewpwd == newpwd) {
                    $('#renewpwd2').text('新密码正确')
                    document.getElementById('sub').style.display=""
                }else {
                    $('#renewpwd2').text('新密码错误')
                    document.getElementById('sub').style.display="none"
                }
            })
        })

    </script>
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
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>密码修改页面</span>
        </div>
        <div class="providerAdd">

            <form action="${pageContext.request.contextPath}/userTable/updateByPrimaryKeyUser" method="post">
                <input type="hidden" name="userId" value="${sessionScope.userId}">

                <!--div的class 为error是验证错误，ok是验证成功-->
                <div class="oldpwd">
                    <label for="oldpwd">旧密码：</label>
                    <input type="password" name="oldpwd" id="oldpwd"
                           placeholder="请填写当前密码"> <span
                        style="color: #F00; margin-top: 5px;">*</span> <span id="oldpwd2"></span>
                </div>
                <div id="n" style="display: none">
                    <label for="newpwd">新密码：</label>
                    <input type="password" name="newpwd" id="newpwd"
                           placeholder="请填写新的密码" style="display: none"> <span
                        style="color: #F00; margin-top: 5px;">*</span> <span id="newpwd2"></span>
                </div>
                <div id="r" style="display: none">
                    <label for="renewpwd" >确认新密码：</label>
                    <input type="password" name="userPwd" id="renewpwd"
                           placeholder="请确认新的密码" style="display: none"> <span
                        style="color: #F00; margin-top: 5px;">*</span> <span id="renewpwd2"></span>
                </div>
                <div class="providerAddBtn">
                    <input type="submit" value="保存" id="sub" style="display: none"/>
                </div>
            </form>
        </div>
    </div>
</section>
<footer class="footer">
</footer>
<script src="${pageContext.request.contextPath}/res/static/js/time.js"></script>

</body>
</html>