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
import model.UniversityDAO;
import model.UniversityDTO;

public class AddUniversityController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String err = "";
        String mess = "";
        String url = "university_form.jsp";
        try {
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String shortName = request.getParameter("shortName");
            String description = request.getParameter("description");
            String foundedYear = request.getParameter("foundedYear");
            String address = request.getParameter("address");
            String city = request.getParameter("city");
            String region = request.getParameter("region");
            String type = request.getParameter("type");
            String totalStudents = request.getParameter("totalStudents");
            String totalFaculties = request.getParameter("totalFaculties");
            String isDraft = request.getParameter("isDraft");

            // Validate ID
            if (id == null || id.trim().isEmpty()) {
                err += "Chua nhap id<br/>";
            }

            // Validate name
            if (name == null || name.trim().isEmpty()) {
                err += "Chua nhap name<br/>";
            }

            // Parse and validate foundedYear
            int s_foundedYear = 0;
            try {
                s_foundedYear = Integer.parseInt(foundedYear);
                if (s_foundedYear < 0) {
                    err += "Nam thanh lap phai la so nguyen duong<br/>";
                }
            } catch (Exception e) {
                err += "Nam thanh lap phai la so nguyen<br/>";
            }

            // Parse and validate totalStudents
            int s_totalStudents = 0;
            try {
                s_totalStudents = Integer.parseInt(totalStudents);
                if (s_totalStudents < 0) {
                    err += "Tong so sinh vien phai la so nguyen duong<br/>";
                }
            } catch (Exception e) {
                err += "Tong so sinh vien phai la so nguyen<br/>";
            }

            // Parse and validate totalFaculties
            int s_totalFaculties = 0;
            try {
                s_totalFaculties = Integer.parseInt(totalFaculties);
                if (s_totalFaculties < 0) {
                    err += "So nhan vien phai la so nguyen duong<br/>";
                }
            } catch (Exception e) {
                err += "So nhan vien phai la so nguyen<br/>";
            }

            // Parse isDraft
            boolean s_isDraft = (isDraft != null && isDraft.equals("on"));

            UniversityDAO dao = new UniversityDAO();

            // Check duplicate ID only if ID is valid
            if (id != null && !id.trim().isEmpty()) {
                UniversityDTO existingU = dao.searchById(id);
                if (existingU != null) {
                    err += "ID da ton tai, Vui long nhap ID khac<br/>";
                }
            }

            // Only proceed if no errors
            if (err.isEmpty()) {
                UniversityDTO u = new UniversityDTO(id, name, shortName, description,
                        s_foundedYear, address, city, region, type,
                        s_totalStudents, s_totalFaculties, s_isDraft);

                if (dao.add(u)) {
                    response.sendRedirect("search?mess=Them thanh cong!");
                    return;
                } else {
                    err = "Gap loi khi them University<br/>";
                }
            }

            // If there are errors, preserve form data
            if (!err.isEmpty()) {
                UniversityDTO u = new UniversityDTO(id, name, shortName, description,
                        s_foundedYear, address, city, region, type,
                        s_totalStudents, s_totalFaculties, s_isDraft);
                request.setAttribute("u", u);
            }

            request.setAttribute("err", err);

        } catch (Exception e) {
            e.printStackTrace();
            err = "Loi he thong: " + e.getMessage();
        request.setAttribute("err", err);
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
