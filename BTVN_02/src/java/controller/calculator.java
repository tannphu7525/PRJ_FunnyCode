/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
@WebServlet(name = "calculator", urlPatterns = {"/cal"})
public class calculator extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet calculator</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet calculator at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String num1Raw = request.getParameter("num1");
        String num2Raw = request.getParameter("num2");
        String op = request.getParameter("op");

        String mess = "";
        String error = "";

        try {
            double num1 = Double.parseDouble(num1Raw);
            double num2 = Double.parseDouble(num2Raw);
            double result = 0;

            switch (op) {
                case "+":
                    result = num1 + num2;
                    mess = String.format("%.0f + %.0f = %.0f", num1, num2, result);
                    break;
                case "-":
                    result = num1 - num2;
                    mess = String.format("%.0f - %.0f = %.0f", num1, num2, result);
                    break;
                case "*":
                    result = num1 * num2;
                    mess = String.format("%.0f * %.0f = %.0f", num1, num2, result);
                    break;
                case "/":
                    if (num2 == 0) {
                        error = "Khong the chia cho so 0";
                    } else {
                        result = num1 / num2;
                        mess = String.format("%.0f / %.0f = %.0f", num1, num2, result);
                    }
                    break;
                default:
                    error = "Vui long chon phep tinh";
            }
        } catch (NumberFormatException e) {
            error = "Loi!!! Du lieu nhap vao khong phai la so hop le";
        } catch (Exception e) {
            error = "Loi he thong!!! ";
        }
        
        if (error.isEmpty()) {
            request.setAttribute("result", mess);
        } else {
            request.setAttribute("error", error);
        }
        
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
