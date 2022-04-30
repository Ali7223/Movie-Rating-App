<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Please fill up this form to sign up</h2>
<h3>only over 18 allowed to sign up</h3>
<p>registration for user with some nice fieldset and legend tags</p>
<form action="user?action=register" method="post" >
<fieldset>
    <legend>UserRegistration</legend>
    <table>
    <tr>
    <td>Username</td>
    <td>:</td>
    <td><input type="text" name="username"></td>
    </tr>
    <tr>
    <td>Age</td>
     <td>:</td>
    <td><input type="text" name="age"></td>
    </tr>
    <tr>
    <td>Email</td>
     <td>:</td>
    <td><input type="text" name="email"></td>
    </tr>
    <tr>
    <td></td>
    <td><input type="submit" value="Register"></td>
    </tr>
    </table>
</fieldset>
</form>
</body>
</html>