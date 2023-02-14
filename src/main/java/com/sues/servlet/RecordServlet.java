package com.sues.servlet;

import com.sues.pojo.Record;
import com.sues.pojo.User;
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
import java.util.List;

@WebServlet("/record")
public class RecordServlet extends HttpServlet {

    RecordService service;

    @Override
    public void init() throws ServletException {
        service = new RecordServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Context context = new Context();
        User user = (User) req.getSession().getAttribute("user");
        context.setVariable("name", user.getName());
        context.setVariable("recordList", service.getRecordList());
        ThymeleafUtil.process("records.html", context, resp.getWriter());
    }
}
