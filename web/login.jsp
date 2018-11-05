<%-- 
    Document   : login
    Created on : Nov 3, 2018, 3:50:09 PM
    Author     : hannah
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link href="css/login.css" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <jsp:useBean id="ub" class="pkg1.myBean" scope="session" />
    </head>
    <body>  
        <form action="/Assignment3/LoginServlet" method="post" class="formLogin">
            <h1 class="font-weight-normal">Please Login</h1>
            <label for="inputName" class="sr-only">username</label>
            <input type="text" id="username" name="uname" class="form-control" placeholder="Username" required autofocus>
            <label for="inputPassword" class="sr-only">Password</label>
            <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required>
            <button id="login" class="btn btn-lg btn-primary btn-block" type="submit">login</button>   
         
            <p>${hint}</p>
        </form>
    </body>
</html>
