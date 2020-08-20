package com.jiamy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author jiamy
 * @Description :
 * @Create on : 2020/8/20 16:37
 **/

@WebServlet(urlPatterns = "/aaa")
public class HelloServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 设置响应类型:
        resp.setContentType("text/html");
        String name = req.getParameter("name");
        // 获取输出流:
        PrintWriter pw = resp.getWriter();
        // 写入响应:
        pw.write("<h1>Haaaaaaaaaello, "+name+"!</h1>");
        // 最后不要忘记flush强制输出:
        pw.flush();
    }
}
