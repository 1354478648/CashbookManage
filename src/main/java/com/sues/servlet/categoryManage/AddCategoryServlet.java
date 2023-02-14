package com.sues.servlet.categoryManage;

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

@WebServlet("/addCategory")
public class AddCategoryServlet extends HttpServlet {
    CategoryService service;
    @Override
    public void init() throws ServletException {
        service = new CategoryServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Context context = new Context();
        ThymeleafUtil.process("addCategory.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String Name = req.getParameter("Name");
        String Type = req.getParameter("Type");
        String Status = req.getParameter("Status");
        service.addCategory(Name,Type,Status);
        //重定向到record
        resp.sendRedirect("category");
    }
}
