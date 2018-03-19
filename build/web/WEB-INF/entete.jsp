<%-- 
    Document   : entete
    Created on : 5 mars 2018, 08:39:55
    Author     : tiago
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="fr.englishbattle.pojos.Joueur"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <h1>English Battle</h1>
        <p>Utilisateur: ${namej} </p>
        <a href="/EnglishBattle/Deconnexion">Déconnexion</a>
    </body>
</html>
