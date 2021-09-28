package com.example.hw2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private static final String LOGIN = "LOGIN";
    private static final String PASSWORD = "PASSWORD";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (req.getParameter("login").equalsIgnoreCase(LOGIN) &&
            req.getParameter("password").equalsIgnoreCase(PASSWORD)) {
            session.setAttribute("logged", "true");
        }
        else {
            session.setAttribute("logged", "false");
        }
        resp.sendRedirect("index.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().removeAttribute("logged");
        resp.sendRedirect("index.jsp");
    }
}
