package com.sues.servlet;

import com.sues.pojo.User;
import com.sues.service.RecordService;
import com.sues.service.UserService;
import com.sues.service.impl.RecordServiceImpl;
import com.sues.service.impl.UserServiceImpl;
import com.sues.utils.ThymeleafUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.context.Context;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/account")
public class AccountServlet extends HttpServlet {
    UserService service;

    @Override
    public void init() throws ServletException {
        service = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Context context = new Context();
        User user = (User) req.getSession().getAttribute("user");
        context.setVariable("name", user.getName());
        ThymeleafUtil.process("account.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nickname = req.getParameter("nickname");
        String oldPassword = req.getParameter("originPassword");
        String newPassword = req.getParameter("newFirstPassword");
        //判断昵称是否为空，如果不是空的，那就说明用户想修改昵称，走修改昵称
        if (nickname != null) {
            User user = (User) req.getSession().getAttribute("user");
            String id = user.getId();
            service.updateName(nickname, id);
            user.setName(nickname);
            req.getSession().setAttribute("user", user);
            resp.sendRedirect("account");
        //如果昵称是空的，那就说明用户想修改密码，走修改密码
        } else {
            User user = (User) req.getSession().getAttribute("user");
            String id = user.getId();
            //从数据库中获取正确的旧密码
            String originPassword = service.getOriginPassword(id);
            //两次新密码不相同直接在js中拦了
            //首先判断用户所填写的旧密码和数据库旧密码是否相同
            if(originPassword.equals(oldPassword)){
                //如果相同，那就判断用户是不是在重复设置新旧相同的密码
                if (oldPassword.equals(newPassword)){
                    resp.setContentType("text/html");
                    PrintWriter out = resp.getWriter();
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('您的新密码似乎和旧密码是一样的！');");
                    out.println("history.back();");
                    out.println("</script>");
                    //如果以上两个判断都通过了，那就修改
                } else {
                    service.updatePassword(newPassword, id);
                    resp.sendRedirect("account");
                }
            //如果用户所填写的旧密码和数据库旧密码不相同，那就警告输入的旧密码不相同
            }else{
                resp.setContentType("text/html");
                PrintWriter out = resp.getWriter();
                out.println("<script type=\"text/javascript\">");
                out.println("alert('您输入的旧密码不正确！');");
                out.println("history.back();");
                out.println("</script>");
            }
        }
    }
}
