package com.sues.servlet;

import com.sues.pojo.User;
import com.sues.service.CategoryService;
import com.sues.service.RecordService;
import com.sues.service.impl.CategoryServiceImpl;
import com.sues.service.impl.RecordServiceImpl;
import com.sues.utils.ThymeleafUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.context.Context;

import java.io.IOException;

@WebServlet("/category")
public class CategoryServlet extends HttpServlet {
    CategoryService service;

    @Override
    public void init() throws ServletException {
        service = new CategoryServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Context context = new Context();
        User user = (User) req.getSession().getAttribute("user");
        context.setVariable("name", user.getName());
        context.setVariable("categoryList", service.getCategory());
        ThymeleafUtil.process("categorys.html", context, resp.getWriter());
    }
}
