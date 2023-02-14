package com.sues.servlet.recordManage;

import com.sues.service.RecordService;
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

@WebServlet("/searchRecord")
public class SearchRecordServlet extends HttpServlet {
    RecordService service;
    @Override
    public void init() throws ServletException {
        service = new RecordServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String search = req.getParameter("search");

        Context context = new Context();
        context.setVariable("recordList", service.getRecordListBySearch(search));

        StringWriter stringWriter = new StringWriter();
        ThymeleafUtil.process("records.html", context, stringWriter);
        String html = stringWriter.toString();

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(html);
    }
}
