/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.englishbattle.servlets;

import fr.englishbattle.pojos.Joueur;
import fr.englishbattle.services.JoueurService;
import fr.englishbattle.servlets.InscriptionServlet;
import fr.englishbattle.utils.DataConnect;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tiago
 */
@WebServlet(urlPatterns = {"/Index"})
public class ConnexionServlet extends HttpServlet {

    private JoueurService joueurService = null;

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ConnexionServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ConnexionServlet at " + request.getContextPath() + "</h1>");
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
        String messa = "";
        request.setAttribute("mess", messa);

        this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
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
        String ndc = request.getParameter("email");
        String pwd = request.getParameter("pwd");
        //Joueur jj = joueurService.getJoueurFromEmailAndPassword(ndc, pwd);
        try {
            Connection connection = DataConnect.getConnection();
            joueurService = new JoueurService(connection);
            Joueur jj = joueurService.getJoueurFromEmailAndPassword(ndc, pwd);
            connection.close();
            if (jj != null) {
                String messa = " ";
                request.setAttribute("mess", messa);
                HttpSession session = request.getSession();
                session.setAttribute("Joueur", jj);
                response.sendRedirect(request.getContextPath() + "/Question");

            } else {
                String messa = "Votre email ou votre mot passe est erroné";
                request.setAttribute("mess", messa);
                this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
            }
// TODO : on peu utiliser les méthodes de JoueurService
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {

        }

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
