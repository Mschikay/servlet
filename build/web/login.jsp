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
        <title>JSP Page</title>
        <link href="css/login.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">

    </head>
    <body>  
        <form action="/Assignment3/LoginServlet" method="post" class="formLogin">
            <h1 class="font-weight-normal">Please Login</h1>
            <label for="inputEmail" class="sr-only">Email address</label>
            <input type="text" id="username" class="form-control" placeholder="Username" required autofocus>
            <label for="inputPassword" class="sr-only">Password</label>
            <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
            <button id="login" class="btn btn-lg btn-primary btn-block" type="submit">login</button>   
         
            <%
              String hint = (String)request.getAttribute("hint");
              if (hint!=null){
                out.print(hint);
              }
                %>
        </form>
    </body>
</html>
