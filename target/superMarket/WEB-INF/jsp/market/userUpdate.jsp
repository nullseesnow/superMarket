<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/static/css/public.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/static/css/style.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/res/bootstrap/js/jQuery.js"></script>
</head>


<script>
    function save() {

        var userName = ($("#userName").val());
        var userId = ($("#userId").val());
        var userGender = ($("input:checked[name='userGender']").val());
        var userPhone = ($("#userphone").val());
        var userAddress = ($("#userAddress").val());
        var userGrade = ($("#userGrade").val());

        $.ajax({
            type: "post",
            dataType: "json",
            url: "/userTable/updateByPrimaryKeySelective",
            data: {
                userName: userName,
                userGender: userGender,
                userId: userId,
                userPhone: userPhone,
                userAddress: userAddress,
                userGrade: userGrade
            },
            error: function (msg) {
                {
                    alert("操作成功");
                    history.back(-1);


                }
            }

        });

    }
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
            <span>用户管理页面 >> 用户修改页面</span>
        </div>

        <div class="providerAdd">

            <!--div的class 为error是验证错误，ok是验证成功-->
            <input type="hidden" name="userId" value="${userTable.userId}" id="userId">
            <div>
                <label for="userName">用户名称：</label>
                <input type="text" name="userName" id="userName" value="${userTable.userName}"/>
                <span></span>
            </div>

            <div>

                <label>用户性别：</label>

                <%-- <select name="userGender"  id="userGender">


                         <c:if test="${userTable.userGender eq '男' }"> <option value="男" >男</option></c:if>
                         <c:if test="${userTable.userGender eq 'eq女' }">   <option value="女" >女</option></c:if>



                 </select>--%>
                <%--<c:if test="${userTable.userGender eq '男'}">
                    <input type="radio" name="userGender" value="男" checked="checked" id="userGender"/>男

                </c:if>
                <c: if test="${userTable.userGender eq '女'}">
                    <input type="radio" name="userGender" value="女" checked="checked" id="userGender"/>女

                </c:if>--%>
                    <input name="userGender" type="radio"  value="男"
                           <c:if test="${userTable.userGender eq '男' }">checked</c:if>
                    >男
                    <input name="userGender" type="radio"  value="女"
                           <c:if test="${userTable.userGender eq '女' }">checked</c:if>
                    >女

            </div>

            <div>
                <label for="userphone">用户电话：</label>
                <input type="text" name="userPhone" id="userphone" value="${userTable.userPhone}"/>
                <span></span>
            </div>
            <div>
                <label for="userAddress">用户地址：</label>
                <input type="text" name="userAddress" id="userAddress" value="${userTable.userAddress}"/>
                <span></span>
            </div>
            <div>
                <label>用户类别：</label>
                <select name="userGrade" id="userGrade">

                        <c:if test="${userTable.userGrade == 0 }">
                            <option value="0" readonly="readonly">经理</option>
                        </c:if>
                        <c:if test="${userTable.userGrade == 1}">
                            <option value="1" readonly="readonly">员工</option>
                        </c:if>

                </select>
                <span></span>

            </div>
            <div class="providerAddBtn">
                <!--<a href="${pageContext.request.contextPath}/res/static/#">保存</a>-->
                <!--<a href="${pageContext.request.contextPath}/res/static/userList.html">返回</a>-->
                <input type="button" id="btn" value="保存" onclick="save()"/>
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