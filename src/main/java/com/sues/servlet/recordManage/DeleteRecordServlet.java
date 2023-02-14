package com.sues.servlet.recordManage;

import com.sues.service.RecordService;
import com.sues.service.impl.RecordServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/deleteRecord")
public class DeleteRecordServlet extends HttpServlet {

    RecordService service;
    @Override
    public void init() throws ServletException {
        service = new RecordServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ID = req.getParameter("id");
        service.deleteRecord(ID);

        resp.sendRedirect("record");
    }
}
