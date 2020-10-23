package com.zbinyun;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintStream;
//第一种方式，第二种方式配置在web.xml中
//@WebServlet(name="helloServlet",urlPatterns = "/helloServlet")
public class HelloServlet extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        PrintStream out = new PrintStream(resp.getOutputStream());
        out.println("<html><head><title>servlet</title><body>hello servlet</body></head></html>");
    }
}
