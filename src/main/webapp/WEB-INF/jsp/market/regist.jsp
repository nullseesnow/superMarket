<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>注册</title>
	
    <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/res/static/login/css/login.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/res/static/login/js/jquery.min.js"></script>
<%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/layuiyuansheng/css/layui.css"  media="all">--%>
<%--    <script src="${pageContext.request.contextPath}/res/layuiyuansheng/layui.js" charset="utf-8"></script>--%>

<script>

    $(function () {
        $("#uname").blur(function () {
            var userName=$("#uname").val();
            //判断是否为空
            if (userName == ""){
                return;
            }
            var msgObj=$(this).next(".msg");
            msgObj.html("");
            $.ajax({
                url: "${pageContext.request.contextPath}/userTable/selectByExample2",
                type : 'get',
                datatype:"json",
                data:{"userName":userName},
                success:function(data){

                // 数据库中存在该用户名
                if(data.code == 200){
                    // 将错误信息添加至相应位置
                    //alert(data.code+"1111");

                    $(".msg").text("该用户名已经存在");
                } else {

                    $(".msg").text("该用户名可用");
                }
            },
            error:function(){
                $(".msg").text("校验用户名出现错误");
            }
        });
        });
    });
</script>
</head>
<body class="login_bj" >

<div class="zhuce_body">

    <div class="zhuce_kong">
    	<div class="zc">
        	<div class="bj_bai">
            <h3>欢迎注册</h3>
       	  	  <form action="${pageContext.request.contextPath}/userTable/insertSelective1" method="post" onsubmit="sublim()">
                <input name="userName" type="text" id="uname" class="kuang_txt user" placeholder="账户" required="required">
                  <span class="msg"></span>
                <input name="userPwd" type="password" class="kuang_txt possword" placeholder="密码" required="required"><br>
                <input name="userAddress" type="text" class="kuang_txt address" placeholder="地址" required="required"><br>
                <input name="userPhone" type="text" class="kuang_txt phone" placeholder="手机号" onblur="validatemobile(this.value)" required="required"><br>
                  性别:<input name="userGender" type="radio"  value="男" style="margin-top: 8px" >男
                <input name="userGender" type="radio"  value="女">女<br>

               <%-- <input name="userGrade" type="text" class="kuang_txt yanzm" placeholder="住址">--%>
<%--                  <label class="layui-form-label">用户类型:</label>--%>
<%--                  <div class="layui-input-block">--%>
                  用户类型:&nbsp;&nbsp;&nbsp;<select name="userGrade" style="margin-top: 8px;margin-bottom: 8px">
                      <option value="0">员工</option>
                      <option value="1">经理</option>
                  </select>
                <%--  </select>
                  </div>--%>
                <div>
                	<%--<div class="hui_kuang"><img src="${pageContext.request.contextPath}/res/static/login/images/zc_22.jpg" width="92" height="31"></div>
                	<div class="shuaxin"><a href="${pageContext.request.contextPath}/res/static/login/#"><img src="${pageContext.request.contextPath}/res/static/login/images/zc_25.jpg" width="13" height="14"></a></div>--%>
                        <input type="text" value="" class="" placeholder="请输入验证码"
                               style="height:20px;position: relative; top:-15px; font-size:14px; margin-right: 6px "id ="text">
                        <canvas id="canvas" width="100" height="43" onclick="dj()"
                                style="border: 1px solid #ccc;
        border-radius: 5px;"></canvas>


                </div>
                <%--<div>
               		<input name="" type="checkbox" value=""><span>已阅读并同意<a href="${pageContext.request.contextPath}/res/static/login/#" target="_blank"><span class="lan">《XXXXX使用协议》</span></a></span>
                </div>--%>
                <input name="注册" type="submit" class="btn_zhuce" value="注册" >
                
                </form>
            </div>
        	<div class="bj_right">
                <img src="${pageContext.request.contextPath}/res/static/img/xia.jpg" style="width: 150px" height="240px">
                <p style="margin-top: 50px">已有账号？<a href="${pageContext.request.contextPath}/Page/login3">立即登录</a></p>
            
            </div>
        </div>

    </div>

</div>
    
<div style="text-align:center;">

</div>
<script type="text/javascript">
    function validatemobile(mobile)
    {
        if(mobile.length==0)
        {
            alert('手机号码不能为空！');
            return false;
        }
        if(mobile.length!=11)
        {
            alert('请输入有效的手机号码，需是11位！');
            return false;
        }

        var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
        if(!myreg.test(mobile))
        {
            alert('请输入有效的手机号码！');
            return false;
        }
    }
</script>


<script>
    var show_num = [];
    draw(show_num);
    function dj(){
        draw(show_num);
    }
    function sublim(){
        var val=document.getElementById("text").value;

        var num = show_num.join("");
        if(val==''){
            alert('请输入验证码！');
            window.event.returnValue = false;
        }else if(val == num){
            alert('提交成功！');
            document.getElementById(".input-val").val('');
            draw(show_num);
            return  true;

        }else{
            alert('验证码错误！\n你输入的是:  '+val+"\n正确的是:  "+num+'\n请重新输入！');
            document.getElementById("text").value='';
            draw(show_num);
            window.event.returnValue = false;
        }



    }
    function draw(show_num) {
        var canvas_width=document.getElementById('canvas').clientWidth;
        var canvas_height=document.getElementById('canvas').clientHeight;
        var canvas = document.getElementById("canvas");//获取到canvas的对象，演员
        var context = canvas.getContext("2d");//获取到canvas画图的环境，演员表演的舞台
        canvas.width = canvas_width;
        canvas.height = canvas_height;
        var sCode = "1,2,3,4,5,6,7,8,9,0,q,w,e,r,t,y,u,i,o,p,a,s,d,f,g,h,j,k,l,z,x,c,v,b,n,m";
        var aCode = sCode.split(",");
        var aLength = aCode.length;//获取到数组的长度

        for (var i = 0; i <= 3; i++) {
            var j = Math.floor(Math.random() * aLength);//获取到随机的索引值
            var deg = Math.random() * 30 * Math.PI / 180;//产生0~30之间的随机弧度
            var txt = aCode[j];//得到随机的一个内容
            show_num[i] = txt;
            var x = 10 + i * 20;//文字在canvas上的x坐标
            var y = 20 + Math.random() * 8;//文字在canvas上的y坐标
            context.font = "bold 23px 微软雅黑";

            context.translate(x, y);
            context.rotate(deg);

            context.fillStyle = randomColor();
            context.fillText(txt, 0, 0);

            context.rotate(-deg);
            context.translate(-x, -y);
        }
        for (var i = 0; i <= 5; i++) { //验证码上显示线条
            context.strokeStyle = randomColor();
            context.beginPath();
            context.moveTo(Math.random() * canvas_width, Math.random() * canvas_height);
            context.lineTo(Math.random() * canvas_width, Math.random() * canvas_height);
            context.stroke();
        }
        for (var i = 0; i <= 30; i++) { //验证码上显示小点
            context.strokeStyle = randomColor();
            context.beginPath();
            var x = Math.random() * canvas_width;
            var y = Math.random() * canvas_height;
            context.moveTo(x, y);
            context.lineTo(x + 1, y + 1);
            context.stroke();
        }
    }
    function randomColor() {//得到随机的颜色值
        var r = Math.floor(Math.random() * 256);
        var g = Math.floor(Math.random() * 256);
        var b = Math.floor(Math.random() * 256);
        return "rgb(" + r + "," + g + "," + b + ")";
    }
</script>

</body>
</html>