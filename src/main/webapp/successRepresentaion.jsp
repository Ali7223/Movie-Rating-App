<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

  <%String username = (String)session.getAttribute("name"); %>
  <% String navigation=(String)request.getAttribute("navtype"); %>
  <%if (navigation.equals("register")) {%>
 <% 
  
  String message=(String)request.getAttribute("message");
  out.println(username +  "<br>" + message);
  %>
 <h2> Success Representation</h2>
  <%} else if (navigation.equals("rate")){%>
  <h4> Rate Success Representation</h4>
  
  <%} else if(navigation.equals("addmovie")) { %>
  <% String mov=request.getParameter("name");
  out.println(mov + "<p>Added Successfully by the user,</p>" + username);%>
  <%} %>
 
 <div align="center">
<p>Go to registered webpage for rate, Add and Browse, to go back click default</p>  
<p><a href="registered.jsp">Registered Webpage</a></p>
<p><a href="defaultwebpage.jsp">Default Webpage</a></p>
</div> 
</body>
</html>