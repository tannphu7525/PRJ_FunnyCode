/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.UserDAO;
import models.UserDTO;

/**
 *
 * @author admin
 */
public class MainController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8"); // Fix lỗi font tiếng Việt khi input

        String action = request.getParameter("action");
        UserDAO dao = new UserDAO();

        if (action == null || action.equals("list")) {
            List<UserDTO> list = dao.getAllUser();
            request.setAttribute("USER_LIST", list);
            request.getRequestDispatcher("login.jsp").forward(request, response);
            
        } else if (action.equals("create")) { 
            String fullName = request.getParameter("fullName");
            boolean gender = "male".equals(request.getParameter("gender")); 
            java.sql.Date dob = java.sql.Date.valueOf(request.getParameter("dob"));
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");

            
            UserDTO user = new UserDTO(0, fullName, gender, dob, email, phone);
            dao.insertUser(user);
            response.sendRedirect("controller?action=list");
            
        } else if (action.equals("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            dao.deleteUserById(id);
            response.sendRedirect("controller?action=list");
            
        } else if (action.equals("edit")) {
            int id = Integer.parseInt(request.getParameter("id"));
            UserDTO user = dao.getUserById(id);
            request.setAttribute("USER", user);
            request.getRequestDispatcher("update.jsp").forward(request, response);
            
        } else if (action.equals("update")) {
            int id = Integer.parseInt(request.getParameter("id"));
            String fullName = request.getParameter("fullName");
            boolean gender = "male".equals(request.getParameter("gender"));
            java.sql.Date dob = java.sql.Date.valueOf(request.getParameter("dob"));
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");

            UserDTO user = new UserDTO(id, fullName, gender, dob, email, phone);
            dao.updateUser(user);
            response.sendRedirect("controller?action=list");
        }
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