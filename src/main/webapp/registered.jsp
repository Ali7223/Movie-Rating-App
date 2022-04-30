<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registered webpage</title>
</head>
<body>

<%String username =(String)session.getAttribute("name"); %>

<p>Welcome <b><%=username %></b>  please choose one of the following </p>
<table id="browse">
    <tr>
        <td>
            <form id="browse" action ="user" method="Get">
                  <input type ="submit" id="browse" name="browsemovies" value="browse">
            </form>
         </td>
       
    </tr>

    <tr>

         <td>
             <a href="addmovie.jsp">Add movies</a>
         </td>
    </tr>
    <tr>
         <td>
             <a href="rate.jsp">Rate movies</a> 
         </td>
    </tr>
</table>

<div>

   <p>to go back to the main page click home</p>
     <a href="defaultwebpage.jsp"> Home</a>
</div>

</body>
</html>