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
   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");        
        String url = "";
        
        if (action.equals("login")) {
            url = "login";
        }else if (action.equals("logout")) {
            url = "logout";
        }else if (action.equals("search")) {
            url = "search";
        }else if (action.equals("delete")) {
            url = "delete";
        }else if (action.equals("update")) {
            url = "update";
        }else if (action.equals("add")) {
            url = "add";
        }else if (action.equals("update")) {
            url = "update";
        }
        
        request.getRequestDispatcher(url).forward(request, response);
    }

}
