/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.UserDAO;
import model.UserDTO;

public class LoginController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        
        String txtUsername = request.getParameter("username");
        String txtPassword = request.getParameter("password");
        String url = "error.jsp";
        String msg = "";
        
        if (txtUsername.trim().isEmpty() || txtPassword.trim().isEmpty()) {
            msg = "Vui lòng nhập đầy đủ username và password!";
            request.setAttribute("message", msg);
        }else{
            UserDAO dao = new UserDAO();
            UserDTO user = dao.login(txtUsername, txtPassword);
            
            if (user == null) {
                msg = "Sai tên username hoặc password";
                request.setAttribute("message", msg);
                url = "error.jsp";
            }else{
                HttpSession session = request.getSession();
                if (request.getParameter("remember") != null) {
                    Cookie cuser = new Cookie("cuser", txtUsername);
                    cuser.setMaxAge(60);
                    response.addCookie(cuser);
                }
                session.setAttribute("user", user);
                url = "home.jsp";
            }
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

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
