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

        var supplierId = ($("#supplierId").val());
        var supplierName = ($("#supplierName").val());
        var supplierPeople = ($("#supplierPeople").val());
        var supplierPhone = ($("#supplierPhone").val());
        var supplierAddress = ($("#supplierAddress").val());
        var supplierFax = ($("#supplierFax").val());
        var supplierDescribe = ($("#supplierDescribe").val());

        $.ajax({
            type:"post",
            dataType:"json",
            url:"/supplierTable/updateByPrimaryKeySelective",
            data:{
                supplierId:supplierId,
                supplierName:supplierName,
                supplierPeople:supplierPeople,
                supplierPhone:supplierPhone,
                supplierAddress:supplierAddress,
                supplierFax:supplierFax,
                supplierDescribe:supplierDescribe,
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
            <span>供应商管理页面 >> 供应商修改页</span>
        </div>
        <div class="providerAdd">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <input type="hidden" name="supplierId" value="${supplierTable.supplierId}" id="supplierId">
                <div>
                    <label for="supplierName">供应商名称：</label>
                    <input type="text" name="supplierName" id="supplierName" value="${supplierTable.supplierName}"/>
                    <span ></span>
                </div>
                <div>
                    <label for="supplierPeople">联系人：</label>
                    <input type="text" name="supplierPeople" id="supplierPeople" value="${supplierTable.supplierName}"/>
                    <span></span>

                </div>
                <div>
                    <label for="supplierPhone">联系电话：</label>
                    <input type="text" name="supplierPhone" id="supplierPhone" value="${supplierTable.supplierPhone}"/>
                    <span></span>
                </div>
                <div>
                    <label for="supplierAddress">联系地址：</label>
                    <input type="text" name="supplierAddress" id="supplierAddress" value="${supplierTable.supplierAddress}"/>
                    <span></span>

                </div>
                <div>
                    <label for="supplierFax">微信：</label>
                    <input type="text" name="supplierFax" id="supplierFax" value="${supplierTable.supplierFax}"/>
                    <span></span>

                </div>
                <div>
                    <label for="supplierDescribe">描述：</label>
                    <input type="text" name="supplierDescribe" id="supplierDescribe" value="${supplierTable.supplierDescribe}"/>
                    <span></span>

                </div>
                <div class="providerAddBtn">
                    <!--<a href="${pageContext.request.contextPath}/res/static/#">保存</a>-->
                    <!--<a href="${pageContext.request.contextPath}/res/static/providerList.html">返回</a>-->
                    <input type="button" id="btn" value="保存" onclick="save()"/>
                    <input type="button" value="返回" onclick="history.back(-1)"/>
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