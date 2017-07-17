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
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
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
        
        // Get the values of the submitted form.
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String ageString = request.getParameter("age");
        int age = Integer.parseInt(ageString);
        String[] classes = request.getParameterValues("classes");
        String color = request.getParameter("color");
        String[] hobbies = request.getParameterValues("hobbies");
        String gradDateString = request.getParameter("gradDate");
        LocalDate gradDate = LocalDate.parse(gradDateString);
        
        // Create a student object.
        Student student = new Student(firstName, lastName, age, classes, color, hobbies, gradDate);
            
        // Create the output from the responses the user entered and display them.
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet formServlet</title>"); 
            out.println("<link rel=\"stylesheet\" href=\"styles/main.css\" type=\"text/css\"/>");
            out.println("</head>");
            out.println("<body>");
                out.println("<h1 style=\"background-color:" + color + ";\">Thank you for sharing your information with us</h1>");

                out.println("<p>First name: " + student.getFirstName() + "</p>");
                out.println("<p>Last name: " + student.getLastName() + "</p>");
                out.println("<p>Age: " + student.getAge() + "</p>");

                // Logic for the checkboxes that were submitted.
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

                // Logic for the options of the select that were submitted.
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

                // Format the date the user selected and output it.
                out.println("<p>Expected graduation date: " + student.formatGraduationDate() + "</p>");
                
                // Get and output the days until graduation.
                out.println("<p>Days until graduation date: " + student.daysUntilGraduation() + "</p>");
  
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
