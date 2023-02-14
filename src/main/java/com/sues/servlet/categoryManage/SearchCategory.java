package com.sues.servlet.categoryManage;

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
import java.io.StringWriter;

@WebServlet("/searchCategory")
public class SearchCategory extends HttpServlet {
    CategoryService service;
    @Override
    public void init() throws ServletException {
        service = new CategoryServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String search = req.getParameter("search");

        Context context = new Context();
        context.setVariable("categoryList", service.getCategoryListBySearch(search));

        StringWriter stringWriter = new StringWriter();
        ThymeleafUtil.process("categorys.html", context, stringWriter);
        String html = stringWriter.toString();

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(html);
    }
}
