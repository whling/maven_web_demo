package com.whl.controller;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by 17697 on 2016/12/6.
 */
public class Servlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        printWriter.write("hello whling");
    }
}
