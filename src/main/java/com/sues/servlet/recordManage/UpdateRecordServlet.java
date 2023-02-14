package com.sues.servlet.recordManage;

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

@WebServlet("/updateRecord")
public class UpdateRecordServlet extends HttpServlet {
    //Category的service    //Record的service
    CategoryService categoryService;
    RecordService recordService;

    @Override
    public void init() throws ServletException {
        categoryService = new CategoryServiceImpl();
        recordService = new RecordServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Context context = new Context();
        User user = (User) req.getSession().getAttribute("user");
        context.setVariable("name", user.getName());
        //1.获取分类名称信息
        context.setVariable("getCategoryName", categoryService.getCategoryName());
        String id = req.getParameter("id");
        req.getSession().setAttribute("id", id);
        context.setVariable("preUpdateRecordList", recordService.getPreUpdateRecordList(id));
        ThymeleafUtil.process("updateRecord.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = (String) req.getSession().getAttribute("id");
        String Amount = req.getParameter("Amount");
        String CategoryID = req.getParameter("CategoryID");
        String Type = req.getParameter("Type");
        String Status = req.getParameter("Status");
        String Note = req.getParameter("Note");
        recordService.updateRecord(id, Amount, CategoryID, Type, Status, Note);
        //重定向到record
        resp.sendRedirect("record");
    }
}