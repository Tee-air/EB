<%-- 
    Document   : inscription
    Created on : 5 mars 2018, 08:39:28
    Author     : tiago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body style="margin: 5%">
        <h1>INSCRIPTION IN THE MATRIX</h1>
        <form action="/EnglishBattle/Inscription" method="post">
            <div class="form-row">
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="inputCity">Nom</label>
                        <input type="text" class="form-control" name="nom" value="rimbaud">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="inputCity">Prenom</label>
                        <input type="text" class="form-control" name="prenom" value="tiago">
                    </div>
                </div>
                <div class="form-group col-md-6">
                    <label for="inputEmail4">Email</label>
                    <input type="email" class="form-control" id="inputEmail4" value="tiago@hotmail.com" name="inputEmail" placeholder="Email">
                </div>
                <div class="form-group col-md-6">
                    <label for="inputPassword4">Mot de passe:</label>
                    <input type="password" class="form-control" id="inputPassword4" value="1234" name="inputPassword" placeholder="Password">
                </div>
            </div>
            <div class="form-row">
                <div class="form-group">
                    <label for="exampleFormControlSelect1">Example select</label>
                    <select class="form-control" id="exampleFormControlSelect1" name="ville">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                    </select>
                </div>
                <div class="form-group col-md-2">
                    <label for="inputZip">Zip</label>
                    <input type="text" class="form-control" id="inputZip" name ="zip" value="69000">
                </div>
                <div class="form-group col-md-2">
                    <select name="level">
                        <option value="Beginner">Débutant</option>
                        <option value="Intermediaire">Intermédiaire</option>
                        <option value="Avancer">Avancé</option>
                        <option value="Maitre">Master</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Sign in</button>
            </div>
        </form>
    </body>
</html>
