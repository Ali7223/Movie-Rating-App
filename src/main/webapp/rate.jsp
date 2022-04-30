<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%String username =(String)session.getAttribute("name"); %>
<p><%=username %>please enter movie rating rating here</p>

<form action="user?action=rate" method="post" >
<fieldset>

    <legend>Rate Movie</legend>
    
    <table>
    
    <tr>
    <td>Movie Name</td>
    <td>: <input type="text" name="name"></td>
    </tr>
    
    <tr>
    <td>Rating</td>
    <td>: <input type="text" name="rating"></td>
    </tr>
   
    
    <tr>
    <td></td>
    <td><input type="submit" value="Ratemovie "></td>
    </tr>
    
    </table>
</fieldset>
</form>

<p>to go back to registered webpage</p>
    <form action ="registered.jsp">
          <input type ="submit" value="Registered">
    </form>

</body>
</html>