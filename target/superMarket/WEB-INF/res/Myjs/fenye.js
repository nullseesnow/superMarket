//??????    ??  http://localhost:8080/major/majorAndSchoolAllPage


//页面已加载就    访问  http://localhost:8080/major/majorAndSchoolAllPage
$(function () {
    //先访问第一页
    to_page(1);
});


function to_page(pageNumber) {
    var userName=$("#userName").val();
    $.ajax({
        url: "/userTable/mohu",
        type: "POST",
        data: {pageNumber: pageNumber,userName:userName},
        success: function (result) {
            console.log(result);    //解析json
            build_majors_table(result);
            //总条数
            build_majors_total(result);
            //解析  上一页下一个
            build_majors_page(result);

        }
    });


}


function build_majors_page(result) {
    var numLi = null;
    //为了不重复  进行清空
    $("#pageNav").empty();
    //构建ul
    var ul = $("<ul></ul>").addClass("pagination");
    //首页
    var firstLi = $("<li><a>首页</a></li>");
    //上一页
    var preLi = $("<li><a>上一页</a></li>");
    //下一页
    var nextLi = $("<li><a>下一页</a></li>");
    //尾页
    var lastLi = $("<li><a>末页</a></li>");
    ul.append(firstLi).append(preLi);



    //这里放 中间的 1  2  3   4



    if (result.extend.pageInfo.hasPreviousPage == false) {
        //不能点
        firstLi.addClass("disable");
        preLi.addClass("disable");


    } else {
        firstLi.click(function () {
            //点首页就是pageNumber ==1   直接返回到第一页
            to_page(1);
        });

    }


    //上一页的点击事件
    preLi.click(function () {
        to_page(result.extend.pageInfo.pageNum - 1);
    });
    //下一页的点击事件
    nextLi.click(function () {
        to_page(result.extend.pageInfo.pageNum + 1);
    });

    if (result.extend.pageInfo.hasNextPage == false) {
        //不能点
        lastLi.addClass("disable");
        nextLi.addClass("disable");
    } else {
        lastLi.click(function () {
            //点首页就是pageNumber ==1   直接返回到第一页
            to_page(result.extend.pageInfo.pages);
        });
    }

    ul.append(nextLi).append(lastLi);
    var nav = $("<nav aria-label='Page navigation'></nav>").append(ul);
    $("#pageNav").append(nav);


}


//中间页  上一页下一页留业
function build_majors_total(result) {
    $("#page_total").empty();
    $("#page_total").append("一共" + result.extend.pageInfo.total + "条信息,当前" + result.extend.pageInfo.pageNum + "页");
}


function build_majors_table(result) {

    $("#majorsTbody").empty();
    //解析表格
    var majors = result.extend.pageInfo.list;
    console.log(majors);

    $.each(majors, function (index, item) {

        console.log(index);


        var userId = $("<td></td>").append(item.userId);
        var userName = $("<td></td>").append("<a>" + item.userName + "</a>");
        var userGender = $("<td></td>").append(item.userGender);
        var userAddress = $("<td></td>").append(item.userAddress);
        var userPhone = $("<td></td>").append(item.userPhone);
        var userGrade = $("<td></td>").append(item.userGrade);
        var grade;


  if ( 0== item.userGrade){

     grade="经理"


  }else {grade="员工"

  }





        $("<tr></tr>")
            .append(userId)
            .append(userName)
            .append(userGender)
            .append(userAddress)
            .append(userPhone)
            .append(grade)
            .append(" <td>\n" +
                "                        <a href = \"/userTable/selectByPrimaryKey?userId="+item.userId+" \"><img src=\"/res/static/img/read.png\" alt=\"查看\" title=\"查看\"/></a>\n" +
                "                        <a href = \"/userTable/selectByPrimaryKey1?userId="+item.userId+" \"><img src=\"/res/static/img/xiugai.png\" alt=\"修改\" title=\"修改\"/></a>\n" +
                "                        <a  href = \"javascript:void(0);\" onclick=\"a("+item.userId+")\"\n id='delete' class=\"removeUser\"><img src=\"/res/static/img/schu.png\" alt=\"删除\" title=\"删除\"/></a>\n" +
                "                    </td>")
            .appendTo("#majorsTbody")

        ;
    });


}

function a(userId){

// alert("aaaaaaaaaa")
// alert(userId)
    $.ajax({
        type:"get",
        dataType:"json",
        url:"/userTable/delete",
        data:{
            userId:userId
        },
        success:function (msg){

          to_page();



        }


    });
}
