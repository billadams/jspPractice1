package controllers;

import business.Student;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bill Adams
 */
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

        // Set the default url and message
        String url = "/index.html";
        ArrayList<String> messages = new ArrayList<>();
        
        // Get the current action
        String action = request.getParameter("action");
        if (action == null) {
            // The default action
            action = "gatherUserInfo";
        }
        
        // Set the url to the correct page
        if (action.equals("gatherUserInfo")) {
            url = "/index.html";
        }
        else if (action.equals("submit")) {
            // Get the values of the submitted form.
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String ageString = request.getParameter("age");
            String[] classes = request.getParameterValues("classes");
            String color = request.getParameter("color");
            String[] hobbies = request.getParameterValues("hobbies");
            String gradDateString = request.getParameter("gradDate");

            // Create a student object.
//            Student student = new Student(firstName, lastName, ageString, classes, color, hobbies, gradDate);
                Student student = new Student();

            if (firstName.equals("")){
                messages.add("Please enter your first name");
            }
            else {
                student.setFirstName(firstName);
            }
            
            if (lastName.equals("")) {
               messages.add("Please enter your last name"); 
            }
            else {
                student.setLastName(lastName);
            }
            
            try {
                int age = Integer.parseInt(ageString);
                student.setAge(age);
            }
            catch (Exception e) {
                student.setAge(null);
                messages.add("Please enter an age using integers");
            }
            
            try {
                LocalDate gradDate = LocalDate.parse(gradDateString);
                student.setGradDate(gradDate);
            }
            catch (Exception e) {
                messages.add("Please enter a valid date");
            }
            
            // Set the color to the color the user selected.
            student.setColor(color);
            
            // Attempt to set the classes and hobbies. If they weren't submitted,
            // the view will output that they weren't selected.
            student.setClasses(classes);
            student.setHobbies(hobbies);
            
            // Set the User object in the request object and set the URL
            request.setAttribute("student", student);
            request.setAttribute("messages", messages);
            if (messages.size() != 0) {
                url = "/index.jsp";
            }
            else {
                url = "/thanks.jsp";
            }
        }
        
        // Forward request and response objects to the specified URL
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
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
