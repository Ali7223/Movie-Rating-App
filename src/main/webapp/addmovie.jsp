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
<h3 align="center">
Insert movie into the datsbase
</h3>

<p><b><%=username %></b> is adding a movie in the database

<form action="user?action=addmovie" method="post" >
<fieldset>

    <legend>Add Movie</legend>
    
    <table>
    
    <tr>
    <td>Name</td>
    <td>: <input type="text" name="name"></td>
    </tr>
    
    <tr>
    <td>Date</td>
    <td>: <input type="text" name="date"  >YYYY-MM-DD</td>
    </tr>
    
    <tr>
    <td>Genre</td>
    <td>: <input type="text" name="genre"></td>
    </tr>
    
    <tr>
    <td>Director</td>
    <td>: <input type="text" name="director"></td>
    </tr>
    
    <tr>
    <td>MainActor</td>
    <td>: <input type="text" name="main_actor"></td>
    </tr>
    
    <tr>
    <td></td>
    <td><input type="submit" value="Addmovie "></td>
    </tr>
    
    </table>
</fieldset>
</form>

</body>
</html>