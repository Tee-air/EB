<%-- 
    Document   : question
    Created on : 5 mars 2018, 08:39:42
    Author     : tiago
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <c:import url="entete.jsp" ></c:import>
    <body style="margin: 5%">
        <form action="/EnglishBattle/Question" method="post">
            <h1>Question ${count}: le verbe ${Verbe}</h1>
        <p> ${VerbeP} </br> ${VerbePP}</p>
            <div class="form-group">
                <label for="formGroupExampleInput">Prétérit</label>
                <input type="text" class="form-control" id="formGroupExampleInput" placeholder="Example input" value="Merise" name="Pret">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput2">Participe Passé</label>
                <input type="text" class="form-control" id="formGroupExampleInput2" name="PP" placeholder="Another input" value="Choublanc">
            </div>
            <button type="submit" class="btn btn-primary">Validé</button>
        
        </form>
    </body>
</html>
