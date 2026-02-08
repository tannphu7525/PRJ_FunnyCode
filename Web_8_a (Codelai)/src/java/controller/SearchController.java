/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UniversityDAO;
import model.UniversityDTO;

public class SearchController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String keywords = request.getParameter("keywords");
        String mess = request.getParameter("mess"); 

        if (keywords == null) {
            keywords = "";
        }

        System.out.println(keywords);
        UniversityDAO dao = new UniversityDAO();
        ArrayList<UniversityDTO> list = new ArrayList<>();
        if (keywords.trim().length() > 0) {
            list = dao.filterByName(keywords);
        }

        request.setAttribute("keywords", keywords);
        request.setAttribute("list", list);

        // ✅ Forward message to JSP
        if (mess != null && !mess.isEmpty()) {
            request.setAttribute("mess", mess);
        }

        String url = "search.jsp";
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
