/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        String url = "";

        if (action == null) {
            action = "welcome";
        }
        
        switch (action) {
            case "login":
                url = "login";
                break;
            case "logout":
                url = "logout";
                break;
            case "search":
                url = "search";
                break;
            case "delete":
                url = "delete";
                break;
            case "update":
                url = "update";
                break;
            case "add":
                url = "add";
                break;
            case "welcome":
                url = "welcome.jsp";
                break;
            default:
                url = "index.jsp";
                System.out.println("Loi he thong");
        }

        request.getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
