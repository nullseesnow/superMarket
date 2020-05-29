package com.six;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override//代替的get post 一并都有
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.得到图片的64编码
        String despath = req.getParameter("message");
        //2.用百度提供的方法根据 base64编码来 搜索脸谱

        FaceSearch faceSearch = new FaceSearch();
        String result = faceSearch.search(despath);

        //3.得出结果 是就登录 否就 不让登录
        System.out.println("result"+result);
        resp.getWriter().println(result);
    }
}
