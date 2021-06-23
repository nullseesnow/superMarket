<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/static/css/public.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/static/css/style.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/layui2.5/css/layui.css"  media="all">
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
                <span>商品管理页面</span>
            </div>
            <div class="search">
                <span>商品名称：</span>
                <input type="text" placeholder="请输入商品的名称" id="sname"/>
                <input type="button" value="查询" id="sbtn"/>
              <%--  <input type="button" value="自定义的按钮名" onclick="javascript:$('input[name=\'file\']').click();" />--%>
                <input id="shopFile" type="file" onchange="mhcha()" placeholder="识别商品" class="btn" >
                <a href="${pageContext.request.contextPath}/Page/shopAdd">添加订单</a>
            </div>
            <!--账单表格 样式和供应商公用-->
            <%--<table class="providerTable" cellpadding="0" cellspacing="0">
                <thead class="firstTr">
                    <th width="10%">商品编码</th>
                    <th width="20%">商品名称</th>
                    <th width="10%">价格</th>
                    <th width="10%">商品图</th>
                    <th width="10%">描述</th>
                    <th width="10%">数量</th>
                    <th width="30%">操作</th>
                </thead>
                <tr>
                    <td>213</td>
                    <td>啊啊是</td>
                    <td>￥451</td>
                    <td><img width="50" height="50" src="${pageContext.request.contextPath}/res/static/img/<c:choose><c:when test="${null eq s.Shop_img}">null_img</c:when><c:otherwise>shop01</c:otherwise></c:choose>.jpg"/></td>
                    <td>未付款</td>
                    <td>2015-11-12</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/Page/billView"><img src="${pageContext.request.contextPath}/res/static/img/read.png" alt="查看" title="查看"/></a>
                        <a href="${pageContext.request.contextPath}/Page/billUpdate"><img src="${pageContext.request.contextPath}/res/static/img/xiugai.png" alt="修改" title="修改"/></a>
                        <a href="${pageContext.request.contextPath}/Page/#" class="removeBill"><img src="${pageContext.request.contextPath}/res/static/img/schu.png" alt="删除" title="删除"/></a>
                    </td>
                </tr>
                <tr>
                    <td>PRO-CODE—001</td>
                    <td>测试供应商001</td>
                    <td>邯郸市五得利面粉厂</td>
                    <td>15918230478</td>
                    <td>15918230478</td>
                    <td>2015-11-12</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/res/static/providerView.jsp"><img src="${pageContext.request.contextPath}/res/static/img/read.png" alt="查看" title="查看"/></a>
                        <a href="${pageContext.request.contextPath}/res/static/providerUpdate.jsp"><img src="${pageContext.request.contextPath}/res/static/img/xiugai.png" alt="修改" title="修改"/></a>
                        <a href="${pageContext.request.contextPath}/res/static/#" class="removeBill"><img src="${pageContext.request.contextPath}/res/static/img/schu.png" alt="删除" title="删除"/></a>
                    </td>
                </tr>
            </table>--%>

            <table class="layui-hide" id="test" lay-filter="test"></table>

        </div>
    </section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<%--<div class="remove" id="removeBi">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该订单吗？</p>
            <a href="${pageContext.request.contextPath}/res/static/#" id="yes">确定</a>
            <a href=" ${pageContext.request.contextPath}/res/static/#" id="no">取消</a>
        </div>
    </div>
</div>--%>

    <footer class="footer">
    </footer>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script src="${pageContext.request.contextPath}/res/static/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/res/static/js/js.js"></script>
<script src="${pageContext.request.contextPath}/res/static/js/time.js"></script>
<script src="${pageContext.request.contextPath}/res/layui2.5/layui.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/res/layui2.5/jquery-1.8.3.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/res/static/js/upload.js"></script>
<script type="text/html" id="imgtmp">
<img src="{{d.shopImg==null?'../../res/static/img/null_img.jpg':d.shopImg}}" style="width: 40px;height:40px;">
</script>
<script>
    $(function () {
        jiazai();
        $("#sbtn").click(function () {
            jiazai();
        })
    })

    /* 模糊查询  通过图片识别 */
    function mhcha() {
        var fileName = $("#shopFile").val();
        var temp =fileName.split("\\");
        var fname = temp[temp.length-1];
        $.ajax({
            url: "/shopTable/mohuByAI",
            type: "POST",
            data: {fname:fname},
            success: function (result) {

                var shName = result.extend.shopName;
                console.log(result);
                $("#sname").val(shName);
                jiazai();
                $("#shopFile").val("");
            }
        })
    }
    function jiazai(){
    layui.use('table', function(){
        var sname = $("#sname").val();
        var table = layui.table;
        var nuImg="../../res/static/img/null_img.jpg";
        table.render({
            elem: '#test'
            ,url:'${pageContext.request.contextPath}/shopTable/selectByPage?sname='+sname+''
            ,cols: [[
                {type:'checkbox'}
                ,{field:'shopId', width:80, title: '商品ID', sort: true}
                ,{field:'shopName', width:200, title: '商品名'}
                ,{field:'shopPrice', width:80, title: '商品价格', sort: true}
                ,{field:'shopImg', width:80, title: '商品图片',align: "center", templet: "#imgtmp"}
                ,{field:'shopDescribe', width:100, title: '商品描述'}
                ,{field:'shopNum', width:80, title: '商品数量'}
                ,{fixed: 'right', width: 165, align:'center', toolbar: '#barDemo'}
            ]]
            ,page: true  // 开启服务端分页
        });
        table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
            var data = obj.data //获得当前行数据
                ,layEvent = obj.event; //获得 lay-event 对应的值
            console.log(data);
            if(layEvent === 'detail'){

                layer.msg('查看操作');
                layer.open({
                    title: '商品详情'
                    ,content:"" +
                        "<table border='0' cellspacing='40'>\n" +
                        "    <tr><td width='100px'>商品ID：</td>" +
                        "<td>"+data.shopId+"</td></tr>\n" +
                        "    <tr><td>商品名称：</td>" +
                        "<td>"+data.shopName+"</td></tr>\n" +
                        "    <tr><td>商品价格</td>" +
                        "<td>"+data.shopPrice+"</td></tr>\n" +
                        "    <tr><td>商品图片</td>" +
                        "<td><img style=\"max-height: 100px;max-width: 100px\" src="+(data.shopImg!=null?data.shopImg:nuImg)+"/></td></tr>\n" +
                        "    <tr><td>商品描述</td>" +
                        "<td>"+data.shopDescribe+"</td></tr>\n" +
                        "    <tr><td>商品数量</td>" +
                        "<td>"+data.shopNum+"</td></tr>\n" +
                        "</table>"
                });
            } else if(layEvent === 'del'){
                layer.confirm('真的删除行么', function(index){
                    /*obj.del(); *///删除对应行（tr）的DOM结构
                    var shopId=obj.data.shopId;
                    console.log(shopId);
                    $.ajax({
                        url:"${pageContext.request.contextPath}/shopTable/deleteByPrimaryKey",
                        type:"post",
                        data:{shopId:shopId},
                        success:function (result) {
                            if (result.code==200){
                                obj.del();
                            }
                        }
                    });
                    layer.close(index);
                    //向服务端发送删除指令
                });
            } else if(layEvent === 'edit'){
                //layer.msg('编辑操作');
                /*layer.config({
                    path: '/res/static/js/upload.js'   //layer.js所在的目录，可以是绝对目录，也可以是相对目录
                });*/
                layer.open({
                    type: 1,
                    skin: 'layui-layer-rim', //加上边框
                    area: ['420px', '470px'], //宽高
                    title:"编辑页面",
                    path:'${pageContext.request.contextPath}/res/static/js/upload.js',
                    content:"<form action=\"/shopTable/updateByPrimaryKey\" method=\"post\">\n" +
                        "                  <%--   shopId shopName shopPrice; shopImg; shopDescribe; shopNum;--%>\n" +
                        " <div style=\"display: none\">\n" +
                        "                          <label for=\"shopId\">商品编码：</label>\n" +
                        "                          <input type=\"text\" name=\"shopId\" value=\""+data.shopId+"\" id=\"shopId\"/>\n" +
                        "                          <span>*请输入商品编码</span>\n" +
                        "                      </div>"+
                        "                    <!--div的class 为error是验证错误，ok是验证成功-->\n" +
                        "                <div>\n" +
                        "                    <label for=\"shopName\">商品名称：</label>\n" +
                        "                    <input type=\"text\" name=\"shopName\" id=\"shopName\" value=\""+data.shopName+"\" />\n" +
                        "                    <span >*请输入商品名称</span>\n" +
                        "                </div>\n" +
                        "                <div>\n" +
                        "                    <label for=\"shopPrice\">价格：</label>\n" +
                        "                    <input type=\"text\" name=\"shopPrice\" id=\"shopPrice\" value=\""+data.shopPrice+"\"/>\n" +
                        "                    <span>*请输入价格</span>\n" +
                        "\n" +
                        "                      <img src=\""+(data.shopImg!=null?data.shopImg:nuImg)+"\"   style=\"max-height: 100px;max-width: 100px ;margin-left: 50px\">\n" +
                        "                      <div><input type=\"text\" name=\"shopImg\" id=\"shopImg\" value=\""+data.shopImg+"\" style=\"width:150px; display: none\"/>\n" +
                        "                      <img id=\"shopImgShow\">\n" +
                        "                      </div>\n" +
                        "\n" +
                        "                <div>\n" +
                        "                    <label for=\"shopDescribe\">描述：</label>\n" +
                        "                    <textarea type=\"text\" name=\"shopDescribe\" id=\"shopDescribe\">"+data.shopDescribe+"</textarea>\n" +
                        "                    <span></span>\n" +
                        "                </div>\n" +
                        "                <div>\n" +
                        "                    <label for=\"shopNum\">数量：</label>\n" +
                        "                    <input type=\"text\" name=\"shopNum\" value=\""+data.shopNum+"\" id=\"shopNum\"/>\n" +
                        "                    <span></span>\n" +
                        "                </div>\n" +
                        "                <div class=\"providerAddBtn\">\n" +
                        "                    <input type=\"submit\" value=\"修改\"/>\n"
                })
            }
        });
    });
    }
</script>
<img style="margin-left: 50px">
</body>
</html>