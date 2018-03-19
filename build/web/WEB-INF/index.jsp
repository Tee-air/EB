<%-- 
    Document   : index
    Created on : 5 mars 2018, 08:39:06
    Author     : tiago
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="margin: 5%">
        <form action="/EnglishBattle/Index" method="post">
            <h1>Welcome on the English Battle Matrix</h1>
            <div class="form-group">
                <p><% String mess = (String) request.getAttribute("mess");
                    out.println(mess);
                    %></p>
                <label for="exampleInputEmail1">Email address</label>
                <input name ="email" class="form-control" aria-describedby="emailHelp" placeholder="Enter email" value="nicolas.chevalier@sc-services.fr">
                <small  class="form-text text-muted">We'll never share your email with anyone else.</small>
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Password</label>
                <input name="pwd" type="password" class="form-control" placeholder="Password" value="6901">
            </div>
            <div class="form-check">
                <input type="checkbox" class="form-check-input" id="exampleCheck1">
                <label class="form-check-label" for="exampleCheck1">Check me out</label>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
                <a href="/EnglishBattle/Inscription">Inscription</a>
    </body>
</html>
