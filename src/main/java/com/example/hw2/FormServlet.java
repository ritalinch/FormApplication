package com.example.hw2;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "FormServlet", urlPatterns = "/send")
public class FormServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        Statistics statistics = (Statistics) session.getAttribute("stAttribute");
        if (statistics == null) {
            statistics = Statistics.getStatistics();
            session.setAttribute("stAttribute", statistics);
        }
        statistics.update(
                request.getParameter("age"),
                request.getParameter("position"),
                request.getParameter("language"));
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println(statistics);
        out.println("</body></html>");
    }
}