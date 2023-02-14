package com.sues.servlet.categoryManage;

import com.sues.service.CategoryService;
import com.sues.service.RecordService;
import com.sues.service.impl.CategoryServiceImpl;
import com.sues.service.impl.RecordServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/deleteCategory")
public class DeleteCategoryServlet extends HttpServlet {
    CategoryService service;
    @Override
    public void init() throws ServletException {
        service = new CategoryServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ID = req.getParameter("id");
        service.deleteCategory(ID);

        resp.sendRedirect("category");
    }
}
