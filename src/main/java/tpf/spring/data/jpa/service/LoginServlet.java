package tpf.spring.data.jpa.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*
         * 1.获取表单数据
         */
        //处理中文问题
        request.setCharacterEncoding("utf-8");
        //获取参数
        String username = (String)request.getParameter("username");
        String password = (String)request.getParameter("password");
        /*
         * 2.验证用户名和密码是否正确
         */
        if("zhangsan".equals(username) && "111".equals(password)){
            //登陆成功

            //把用户名保存到cookie中，发给客户端
            Cookie cookie = new Cookie("uname",username);
            cookie.setMaxAge(60*60*24);//保存一小天
            response.addCookie(cookie);

            /*
             * 3.保存用户信息到session中
             * 4.重定向到succ1.jsp
             */
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            response.sendRedirect("/day_11-3/session2/succ1.jsp");

        }else{//登录失败
            /*
             * 5.保存错误信息到request域中
             * 6.转发到login.jsp
             */
            request.setAttribute("msg", "用户名或密码错误");
            RequestDispatcher qr = request.getRequestDispatcher("/session2/login.jsp");
            qr.forward(request,response);

        }
    }

}