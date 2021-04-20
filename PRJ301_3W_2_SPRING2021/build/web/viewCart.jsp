<%-- 
    Document   : viewCart
    Created on : Apr 19, 2021, 12:49:39 PM
    Author     : HP
--%>

<%@page import="sample.dtos.TeaDTO"%>
<%@page import="sample.dtos.CartDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View shopping cart</title>
    </head>
    <body>
        <h1>You chose: </h1>
        <%
            CartDTO cart = (CartDTO)session.getAttribute("CART");
            if(cart != null){
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Total</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    double total = 0;
                    for(TeaDTO tea : cart.getCart().values()){
                        total += tea.getPrice() * tea.getQuantity();
                %>
            <form action="MainController">
                <tr>
                    <td><%= count ++%></td>
                    <td>
                        <%= tea.getId()%>
                        <input type="hidden" name="id" value="<%= tea.getId()%>"/>
                    </td>
                    <td><%= tea.getName()%></td>
                    <td>
                        
                        <input type="number" name="quantity" placeholder=" <%= tea.getQuantity()%>"/>
                    </td>
                    <td><%= tea.getPrice()%></td>
                    <td><%= tea.getQuantity() * tea.getPrice()%></td>
                    <td>
                        <input type="submit" name="action" value="Remove"/>
                    </td>
                    <td>
                        <input type="submit" name="action" value="Edit"/>
                    </td>
                </tr>
                </form>
                <%                         
                    }
                %>
            </tbody>
        </table>
            <h1>Total: <%=total%></h1>
        <%
            }
        %>
        <a href="shopping.jsp">Add more</a>
    </body>
</html>
