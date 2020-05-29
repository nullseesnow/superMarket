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

            var supplierId = ($("#supplierId").val());
            var supplierName = ($("#supplierName").val());
            var supplierPeople = ($("#supplierPeople").val());
            var supplierPhone = ($("#supplierPhone").val());
            var supplierAddress = ($("#supplierAddress").val());
            var supplierFax = ($("#supplierFax").val());
            var supplierDescribe = ($("#supplierDescribe").val());
            /*登陆人ID*/
            //获取时间
            $.ajax({
                type:"post",
                dataType:"json",
                url:"/supplierTable/insert",
                data:{
                    supplierId:supplierId,
                    supplierName:supplierName,
                    supplierPeople:supplierPeople,
                    supplierPhone:supplierPhone,
                    supplierAddress:supplierAddress,
                    supplierFax:supplierFax,
                    supplierDescribe:supplierDescribe,
                },
                error:function (msg){

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
            <span>供应商管理页面 >> 供应商添加页面</span>
        </div>
        <div class="providerAdd">
            <form action="${pageContext.request.contextPath}/supplierTable/insertSelective" method="post">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div class="">
                    <label for="supplierId">供应商编码：</label>
                    <input type="text" name="supplierId" id="supplierId"/>
                    <span>*请输入供应商编码</span>
                </div>
                <div>
                    <label for="supplierName">供应商名称：</label>
                    <input type="text" name="supplierName" id="supplierName"/>
                    <span >*请输入供应商名称</span>
                </div>
                <div>
                    <label for="supplierPeople">联系人：</label>
                    <input type="text" name="supplierPeople" id="supplierPeople"/>
                    <span>*请输入联系人</span>

                </div>
                <div>
                    <label for="supplierPhone">联系电话：</label>
                    <input type="text" name="supplierPhone" id="supplierPhone"/>
                    <span>*请输入联系电话</span>
                </div>
                <div>
                    <label for="supplierAddress">联系地址：</label>
                    <input type="text" name="supplierAddress" id="supplierAddress"/>
                    <span></span>
                </div>
                <div>
                    <label for="supplierFax">微信：</label>
                    <input type="text" name="supplierFax" id="supplierFax"/>
                    <span></span>
                </div>
                <div>
                    <label for="supplierDescribe">描述：</label>
                    <input type="text" name="supplierDescribe" id="supplierDescribe"/>
                </div>
                <div class="providerAddBtn">
                    <!--<a href="${pageContext.request.contextPath}/res/static/#">保存</a>-->
                    <!--<a href="${pageContext.request.contextPath}/res/static/providerList.html">返回</a>-->
                    <input type="button" value="保存" id="btn"/>
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