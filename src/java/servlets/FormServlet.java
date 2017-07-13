/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import business.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author da202057
 */
@WebServlet(name = "formServlet", urlPatterns = {"/formServlet"})
public class FormServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String[] classes = null;
        String[] hobbies = null;
        
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String ageString = request.getParameter("age");
        int age = Integer.parseInt(ageString);
        classes = request.getParameterValues("classes");
        String color = request.getParameter("color");
        hobbies = request.getParameterValues("hobbies");
        String gradDateString = request.getParameter("date");
        LocalDate gradDate = (gradDateString);
        
        Student student = new Student(firstName, lastName, age, classes, color, hobbies, gradDate);
            
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet formServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1 style=\"background-color:" + color + ";\">Servlet formServlet at " + request.getContextPath() + "</h1>");
            
            out.println("<h3>First name: " + student.getFirstName() + "</h3>");
            out.println("<h3>Last name: " + student.getLastName() + "</h3>");
            out.println("<h3>Age: " + student.getAge() + "</h3>");
            
            if (student.getClasses() != null) {
                out.println("<p>Classes taken:</p>");
                out.println("<ul>");
                for (String theClass : student.getClasses()) {
                    out.println("<li>" + theClass + "</li>");
                }            
                out.println("</ul>");   
            } else {
                out.println("<p>No classes taken</p>");
            }
            
            out.println("<p>Color chosen: " + student.getColor() + "</p>");
            
            if (student.getHobbies() != null) {
            out.println("<p>Hobbies:</p>");
            out.println("<ul>");
                for (String hobby : student.getHobbies()) {
                    out.println("<li>" + hobby + "</li>");
                }
            out.println("</ul>");               
            } else {
                out.println("<p>Student doesn't have any hobbies</p>");
            }
 
                  
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
