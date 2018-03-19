/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.englishbattle.servlets;

import fr.englishbattle.pojos.Joueur;
import fr.englishbattle.pojos.Ville;
import fr.englishbattle.services.JoueurService;
import fr.englishbattle.services.VilleService;
import fr.englishbattle.utils.DataConnect;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(urlPatterns = {"/Inscription"})
public class InscriptionServlet extends HttpServlet {

    public static ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
    private JoueurService joueurService = null;
    private VilleService villeService = null;
    private Joueur jj = null;
    public static Joueur Checklogin(String email, String mdp) {
        for (Joueur j : joueurs) {
            if (email.equals(j.getEmail()) && mdp.equals(j.getMotDePasse())) {
                return j;
            }
        }
        return null;
    }

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
            out.println("<title>Servlet InscriptionServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InscriptionServlet at " + request.getContextPath() + "</h1>");
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
        try {
            Connection connection = DataConnect.getConnection();
            villeService = new VilleService(connection);
            request.setAttribute("ListVille", villeService.getAll());
            connection.close();
            this.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {

        }
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
        String email = request.getParameter("inputEmail");
        String prenom = request.getParameter("prenom");
        String nom = request.getParameter("nom");
        String mdp = request.getParameter("inputPassword");
        String city = request.getParameter("ville");
        String zip = request.getParameter("zip");
        String niv = request.getParameter("level");
        long idVille = Long.parseLong(request.getParameter("ville"));
        Ville ville1 = new Ville(zip, city);
        System.out.println(idVille);

        try {
            Connection connection = DataConnect.getConnection();
            joueurService = new JoueurService(connection);

            Joueur player = new Joueur(email, nom, prenom, mdp, idVille, niv);
             jj = joueurService.createJoueur(player);
            //joueurs.add(player);
            connection.close();

// TODO : on peu utiliser les méthodes de JoueurService
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {

        }
        //
        // String messa = player.getEmail() + player.getMotDePasse();
        //String messa = "biiiit";
        //request.setAttribute("mess", messa);
        response.sendRedirect(request.getContextPath() + "/Index");
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
