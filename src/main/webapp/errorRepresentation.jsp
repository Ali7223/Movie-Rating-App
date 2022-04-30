<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

 <% String navigation=(String)request.getAttribute("navtype"); %>
  <%if (navigation.equals("register")) {%>
 <% 
  String username = (String)session.getAttribute("name");
  String message=request.getParameter("message");
  out.println(username +  "<br>" + message);
  %>
  <%} else if (navigation.equals("rate")){%>
  <h3>Movie does not exist or already rated by you before</h3>
  <h4> Rate Error Representation</h4>
  
  <%} else if(navigation.equals("addmovie")) { %>
 
  <h4> Add movie Error Representation</h4>
  <%} %>
  
  <div align="center">
  <p>Go to registered webpage for rate, Add and Browse, to go back click default</p>  
<p ><a href="registered.jsp">Registered Webpage</a></p>
<p><a href="defaultwebpage.jsp">Default Webpage</a></p>

</div>

</body>
</html>