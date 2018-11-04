<%-- 
    Document   : checkDue
    Created on : Nov 3, 2018, 4:02:46 PM
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
        <form class="formLogin" action="/Assignment3/SubmitServlet" method="post">
            <h1 class="h3 mb-3 font-weight-normal">Please choose the vegetable you like</h1>
            <div class="checkbox mb-3">
                <label>
                    <input type="checkbox" name="vegetables" value="carrot"> carrot
                </label>
                <label>
                    <input type="checkbox" name="vegetables" value="cucumber"> cucumber
                </label>
                <label>
                    <input type="checkbox" name="vegetables" value="cabbage"> cabbage
                </label>
                <label>
                    <input type="checkbox" name="vegetables" value="coriander"> coriander
                </label>
            </div>
    <button id="like" class="btn btn-lg btn-primary btn-block" type="submit">submit</button>
</form>
    </body>
</html>
