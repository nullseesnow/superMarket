<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/static/css/public.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/static/css/style.css"/>
</head>

<script type="text/javascript" src="${pageContext.request.contextPath}/res/bootstrap/js/jQuery.js"></script>
<script>

    $(function () {

        $("#btn").click(function(){

            var userId = ($("#userId").val());
            var userName = ($("#userName").val());
            var userPwd = ($("#userPwd").val());
            var userGender = ($("#userGender").val());
            var userBirthday = ($("#userBirthday").val());
            var userPhone = ($("#userPhone").val());
            var userAddress = ($("#userAddress").val());
            var userGrade = ($("#userGrade").val());
            /*登陆人ID*/
            //获取时间


            $.ajax({
                type:"get",
                dataType:"json",
                url:"${pageContext.request.contextPath}/userTable/insertSelective",
                    data:{
                    userId:userId,
                    userName:userName,
                    userPwd:userPwd,
                    userGender:userGender,

                    userPhone:userPhone,
                    userAddress:userAddress,
                    userGrade:userGrade
                   },

                success:function (msg){

                        alert("操作成功");

                    history.back(-1);

                    }


            });

        });


    });
</script>



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
            <span>用户管理页面 >> 用户添加页面</span>
        </div>
        <div class="providerAdd">

                <!--div的class 为error是验证错误，ok是验证成功-->
                <div class="">
                    <label for="userId">用户编码：</label>
                    <input type="text" name="userId" id="userId"/>
                    <span>*请输入用户编码，且不能重复</span>
                </div>
                <div>
                    <label for="userName">用户名称：</label>
                    <input type="text" name="userName" id="userName"/>
                    <span >*请输入用户名称</span>
                </div>
                <div>
                    <label for="userPwd">用户密码：</label>
                    <input type="text" name="userPwd" id="userPwd"/>
                    <span>*密码长度必须大于6位小于20位</span>

                </div>
             <%--   <div>
                    <label for="userRemi">确认密码：</label>
                    <input type="text" name="userRemi" id="userRemi"/>
                    <span>*请输入确认密码</span>
                </div>--%>
                <div>
                    <label >用户性别：</label>

                    <select name="userGender" id="userGender">
                        <option value="男">男</option>
                        <option value="女">女</option>
                    </select>
                    <span></span>
                </div>



                <div>
                    <label for="userPhone">用户电话：</label>
                    <input type="text" name="userPhone" id="userPhone"/>
                    <span >*</span>
                </div>
                <div>
                    <label for="userAddress">用户地址：</label>
                    <input type="text" name="userAddress" id="userAddress"/>
                </div>
                <div>
                    <label >用户类别：</label>
                    <select name="userGrade" id="userGrade">
                        <option value="0">经理</option>
                        <option value="1">员工</option>
                    </select>
                    <span></span>

                </div>
                <div class="providerAddBtn">
                    <!--<a href="${pageContext.request.contextPath}/res/static/#">保存</a>-->
                    <!--<a href="${pageContext.request.contextPath}/res/static/userList.html">返回</a>-->
                    <input type="button" id="btn" value="保存" />
                    <input type="button" value="返回" onclick="history.back(-1)"/>
                </div>

        </div>

    </div>
</section>
<footer class="footer">
</footer>
<script src="${pageContext.request.contextPath}/res/static/js/time.js"></script>

</body>
</html>