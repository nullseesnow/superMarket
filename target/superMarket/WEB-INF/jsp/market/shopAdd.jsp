<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/static/css/public.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/static/css/style.css"/>
    <script src="${pageContext.request.contextPath}/res/static/js/showpic.js"></script>
    <script src="${pageContext.request.contextPath}/res/static/js/time.js"></script>
    <script src="${pageContext.request.contextPath}/res/layui2.5/jquery-1.8.3.js"></script>
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
            <span>商品管理页面 >> 商品添加页面</span>
        </div>
        <div class="providerAdd">
            <div style="width: 300px;height: auto;margin-left: 123px">
                <div style="width: 200px;height: 100px">

                <form id="uploadForm" enctype="multipart/form-data">
                    <label for="pic-th"><img id="pic-th-preview" src="${pageContext.request.contextPath}/res/static/img/addPhoto.png" style="width: auto;height: auto;max-height: 100px; max-width: 100px;"/></label>
                    <input type="file" name="file" id="pic-th" style="width:150px; display: none;" onchange="previewFile()"/>
                </form>
            </div>
                <%--<button id="up2">上传</button>--%>
            </div>
            <form action="/shopTable/insert" method="post">
                  <%--   shopId shopName shopPrice; shopImg; shopDescribe; shopNum;--%>
                    <!--div的class 为error是验证错误，ok是验证成功-->
                <div style="display: none">
                    <label for="shopId">商品编码：</label>
                    <input type="text" name="shopId" id="shopId"/>
                    <span>*请输入商品编码</span>
                </div>
                <div>
                    <label for="shopName">商品名称：</label>
                    <input type="text" name="shopName" id="shopName"/>
                    <span >*请输入商品名称</span>
                </div>
                <div>
                    <label for="shopPrice">价格：</label>
                    <input type="text" name="shopPrice" id="shopPrice"
                           onkeyup="value=value.replace(/[^\d\.]/g,'')">
                    <%--只能输入数字 小数点--%>
                    <%--不可粘贴--%>
                    <%--onkeydown="fncKeyStop(event)" onpaste="return false"
                    oncontextmenu="return false"--%>

                    <span>*请输入价格（只能输入数字 小数点）</span>

                </div>
                      <%--数据库添加地址--%>
                      <div><input type="text" name="shopImg" id="shopImg" style="width:150px; display: none"/>
                         <%-- 上传后图片展示--%>
                      <%--<img id="shopImgShow">--%>
                      </div>

                <div>
                    <label for="shopDescribe">描述：</label>
                    <input type="text" name="shopDescribe" id="shopDescribe"><%--</input>--%>
                    <span></span>
                </div>
                <div>
                    <label for="shopNum">数量：</label>
                    <input type="number" name="shopNum" id="shopNum"/>
                    <span></span>
                </div>
                <div class="providerAddBtn">
                    <input type="submit" value="保存"/>
                    <input type="button" value="返回" onclick="history.back(-1)"/>
                </div>
            </form>
        </div>

    </div>
</section>
<footer class="footer">
</footer>
<script>
    $(function () {
        $("#pic-th").change(function () {
            var formData = new FormData($('#uploadForm')[0]);
            console.log(formData);
            $.ajax({
                url:"${pageContext.request.contextPath}/shopTable/upload",
                type:'POST',
                async: false,
                processData : false, // 使数据不做处理
                contentType : false, // 不要设置Content-Type请求头
                data:formData,
            }).success(function (data) {
                $("#shopImg").attr("value",data);
                $("#shopImgShow").attr("src",data);
                console.log(data);

            }).error(function () {
                console.log("失败");
            });
        });
    });

   /* function infile() {
        var formData = new FormData($('#uploadForm')[0]);
        console.log(formData);
        $.ajax({
            url:"/shopTable/upload",
            type:'POST',
            async: false,
            processData : false, // 使数据不做处理
            contentType : false, // 不要设置Content-Type请求头
            data:formData,
        }).success(function (data) {
            $("#shopImg").attr("value",data);
            console.log(data);

        }).error(function () {
            console.log("失败");
        })
    }*/
</script>
</body>
</html>