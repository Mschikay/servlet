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
        <title>Choose Vegetable</title>
        <link href="css/login.css" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    </head>
    <body>
        <form class="formLogin" action="/Assignment3/SubmitServlet" method="post">
            <h1 class="h3 mb-3 font-weight-normal">Hi, <jsp:getProperty name="ub" property="name" />. </h1>
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
    
        <p>${end}</p>
    </body>
</html>
