<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/static/css/public.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/static/css/style.css"/>
    <%--分页 导入--%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/res/bootstrap/js/jQuery.js"></script>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
    <%--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~--%>
</head>
<script src="${pageContext.request.contextPath}/res/Myjs/fenye-dc.js"></script>

<style>
    .row{margin-right:-15px;margin-left:-15px}
    .pagination{display:inline-block;padding-left:0;margin:20px 0;border-radius:4px}.pagination>li{display:inline}.pagination>li>a
                ,.pagination>li>span{position:relative;float:left;padding:6px 12px;margin-left:-1px;line-height:1.42857143;
                color:#337ab7;text-decoration:none;background-color:#fff;border:1px solid #ddd}.pagination>li:first-child>a,
                .pagination>li:first-child>span{margin-left:0;border-top-left-radius:4px;
                border-bottom-left-radius:4px}.pagination>li:last-child>a,.pagination>li:last-child>span{border-top-right-radius:4px;
                border-bottom-right-radius:4px}.pagination>li>a:focus,.pagination>li>a:hover,.pagination>li>span:focus,.pagination>li>
                span:hover{z-index:2;color:#23527c;background-color:#eee;border-color:#ddd}.pagination>.active>a,.pagination>.active>a:
                focus,.pagination>.active>a:hover,.pagination>.active>span,.pagination>.active>span:focus,.pagination>.active>span:hover
                {z-index:3;color:#fff;cursor:default;background-color:#337ab7;border-color:#337ab7}.pagination>.disabled>a,
                .pagination>.disabled>a:focus,.pagination>.disabled>a:hover,.pagination>.disabled>span,.pagination>.disabled>span:
                focus,.pagination>.disabled>span:hover{color:#777;cursor:not-allowed;background-color:#fff;border-color:#ddd}.
                pagination-lg>li>a,.pagination-lg>li>span{padding:10px 16px;font-size:18px;line-height:1.3333333}.pagination-lg>li:
                 first-child>a,.pagination-lg>li:first-child>span{border-top-left-radius:6px;border-bottom-left-radius:6px}.
                 pagination-lg>li:last-child>a,.pagination-lg>li:last-child>span{border-top-right-radius:6px;border-bottom-right-radius:
                6px}.pagination-sm>li>a,.pagination-sm>li>span{padding:5px 10px;font-size:12px;line-height:1.5}.pagination-sm>li:
                first-child>a,.pagination-sm>li:first-child>span{border-top-left-radius:3px;border-bottom-left-radius:3px}.pagination-sm>
                li:last-child>a,.pagination-sm>li:last-child>
                span{border-top-right-radius:3px;border-bottom-right-radius:3px}
</style>

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
            <span>供应商管理页面</span>
        </div>
        <div class="search">
            <form action="${pageContext.request.contextPath}/supplierTable/mohu"  method="post" >
            <span>供应商名称：</span>
            <input type="text" name="supplierName" id="supplierName" placeholder="请输入供应商的名称"/>
                <input type="button" id="btn" value="查询" onclick="to_page()"/>
            <a href="/Page/providerAdd">添加供应商</a>
            </form>
        </div>
        <!--供应商操作表格-->
        <table class="providerTable" cellpadding="0" cellspacing="0">
            <tr class="firstTr">
                <th width="10%">供应商编码</th>
                <th width="15%">供应商名称</th>
                <th width="10%">联系人</th>
                <th width="10%">联系电话</th>
                <th width="10%">地址</th>
                <th width="10%">微信</th>
                <th width="15%">描述</th>
                <th width="30%">操作</th>
            </tr>
            <tbody id="majorsTbody">

            </tbody>
        </table>
        <div class="row" id="pageNav" style="margin-left: 35%">
            <%--分页信息  1  2  3   4  上一页  下一页--%>

            <div id="page_total">

            </div>
        </div>
    </div>
</section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeProv">
   <div class="removerChid">
       <h2>提示</h2>
       <div class="removeMain" >
           <p>你确定要删除该供应商吗？</p>
           <a href="${pageContext.request.contextPath}/res/static/#" id="yes">确定</a>
           <a href="${pageContext.request.contextPath}/res/static/#" id="no">取消</a>
       </div>
   </div>
</div>


<footer class="footer">
</footer>

<script src="${pageContext.request.contextPath}/res/static/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/res/static/js/js.js"></script>
<script src="${pageContext.request.contextPath}/res/static/js/time.js"></script>

</body>
</html>