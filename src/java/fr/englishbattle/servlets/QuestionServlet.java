/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.englishbattle.servlets;

import fr.englishbattle.pojos.Joueur;
import fr.englishbattle.pojos.Partie;
import fr.englishbattle.pojos.Question;
import fr.englishbattle.pojos.Verbe;
import fr.englishbattle.services.JoueurService;
import fr.englishbattle.services.PartieService;
import fr.englishbattle.services.QuestionService;
import fr.englishbattle.services.VerbeService;
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
@WebServlet(urlPatterns = {"/Question"})
public class QuestionServlet extends HttpServlet {

    public List<Question> Q = new ArrayList<>();
    public List<Verbe> QAll = new ArrayList<>();
    private String NomVerbeActuel;
    private PartieService partieService = null;
    private VerbeService verbeService = null;
    private QuestionService questionService = null;

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
            out.println("<title>Servlet QuestionServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet QuestionServlet at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        Joueur J = (Joueur) session.getAttribute("Joueur");
        request.setAttribute("namej", J.getNom());
        Partie partie = new Partie(J);
        try {
            Connection connection = DataConnect.getConnection();
            partieService = new PartieService(connection);
            verbeService = new VerbeService(connection);
            questionService = new QuestionService(connection);
            QAll = verbeService.getAll();
            
            
            partieService.createPartie(partie);
            
            //joueurs.add(player);
            connection.close();

// TODO : on peu utiliser les méthodes de JoueurService
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {

        }
        Verbe v1 = new Verbe("Arise", "Arose", "Arisen", "Survenir");
        Question Quest1 = new Question(partie, v1);
        Q.add(Quest1);
        Verbe v2 = new Verbe("be", "Was/Were", "been", "être");
        Question Quest2 = new Question(partie, v2);
        Q.add(Quest2);
        Verbe v3 = new Verbe("Can", "Could", "Could", "Pouvoir");
        Question Quest3 = new Question(partie, v3);
        Q.add(Quest3);
        Verbe v4 = new Verbe("Dig", "dug", "dug", "Creuser");
        Question Quest4 = new Question(partie, v4);
        Q.add(Quest4);
        Verbe v5 = new Verbe("Give", "Gave", "Given", "Donner");
        Question Quest5 = new Question(partie, v5);
        Q.add(Quest5);
        partie.setQuestions(Q);
        request.setAttribute("count", 1);
        request.setAttribute("Verbe", Q.get(0).getVerbe().getBaseVerbale());
        request.setAttribute("VerbeP", Q.get(0).getVerbe().getPreterit());
        request.setAttribute("VerbePP", Q.get(0).getVerbe().getParticipePasse());
        NomVerbeActuel = Q.get(0).getVerbe().getBaseVerbale();
        this.getServletContext().getRequestDispatcher("/WEB-INF/question.jsp").forward(request, response);

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
        HttpSession session = request.getSession();
        Joueur J = (Joueur) session.getAttribute("Joueur");
        request.setAttribute("namej", J.getNom());
        String Pret = (String) request.getParameter("Pret");
        String PP = (String) request.getParameter("PP");
        int x = Q.size() - 1;
        boolean valid = false;
        int i;
        for (i = 0; i <= x; i++) {
            if (NomVerbeActuel.equals(Q.get(i).getVerbe().getBaseVerbale()) && Pret.equals(Q.get(i).getVerbe().getPreterit()) && PP.equals(Q.get(i).getVerbe().getParticipePasse())) {
                request.setAttribute("Verbe", Q.get(i + 1).getVerbe().getBaseVerbale());
                request.setAttribute("count", i + 2);
                request.setAttribute("VerbeP", Q.get(i + 1).getVerbe().getPreterit());
                request.setAttribute("VerbePP", Q.get(i + 1).getVerbe().getParticipePasse());
                NomVerbeActuel = Q.get(i + 1).getVerbe().getBaseVerbale();
                valid = true;
            }
        }

        if (valid) {
            // if (i == 5) {
            //    response.sendRedirect(request.getContextPath() + "/bravo.jsp");
            // } else {
            this.getServletContext().getRequestDispatcher("/WEB-INF/question.jsp").forward(request, response);
            //}

        } else {
            request.setAttribute("mess", "Vous avez donner une réponse incorrect");
            this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
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
