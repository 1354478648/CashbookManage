package com.sues.servlet.categoryManage;

import com.sues.pojo.User;
import com.sues.service.CategoryService;
import com.sues.service.impl.CategoryServiceImpl;
import com.sues.utils.ThymeleafUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.context.Context;

import java.io.IOException;

@WebServlet("/updateCategory")
public class UpdateCategoryServlet extends HttpServlet {
    CategoryService service;
    @Override
    public void init() throws ServletException {
        service = new CategoryServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Context context = new Context();
        String id = req.getParameter("id");
        req.getSession().setAttribute("id", id);
        context.setVariable("preUpdateCategoryList", service.getPreUpdateCategoryList(id));
        ThymeleafUtil.process("updateCategory.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = (String) req.getSession().getAttribute("id");
        String Name = req.getParameter("Name");
        String Type = req.getParameter("Type");
        String Status = req.getParameter("Status");
        service.updateCategory(Name,Type,Status,id);
        resp.sendRedirect("category");
    }
}
