<%-- 
    Document   : insert
    Created on : Apr 16, 2021, 10:49:23 AM
    Author     : HP
--%>

<%@page import="sample.dtos.UserErrorDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create new user</title>
    </head>
    <body>
        <%
            UserErrorDTO errorUser = (UserErrorDTO)request.getAttribute("ERROR_USER");
            if(errorUser == null){
                errorUser = new UserErrorDTO("", "", "", "", "");//chỗ này là 1 nghê thuật coding
            }
        %>
       <form action="MainController" method="POST">
        User ID<input type="text" name="userID" required=""/></br>
        <%= errorUser.getUserIDError()%></br>
        Full Name<input type="text" name="fullName" required=""/></br>
        <%= errorUser.getFullNameError()%></br>
        Role ID<input type="text" name="roleID" required=""/></br>
        <%= errorUser.getRoleIDError()%></br>
        Password<input type="password" name="password" required=""/></br>
        Confirm<input type="password" name="confirm" required=""/></br>
        <%= errorUser.getConfirmError()%></br>
        <input type="submit" name="action" value="Create"/></br>
        <input type="reset" value="Reset"/></br>
    </form> 
    </body>
    
</html>
