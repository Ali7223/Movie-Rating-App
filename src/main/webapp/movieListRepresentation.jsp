<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- Import Array List package -->
<%@page import="java.util.ArrayList" %>
<%@page import="dbadapter.moviebean" %>

<%ArrayList<moviebean> movies=(ArrayList)request.getAttribute("list"); %>
<%String username = (String)session.getAttribute("name"); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>movie list representation for logged in user <b><%=username %></b></p>


<table>
  <thead>
   <tr>
      <th>Name</th>
      <th>Main Actor</th>
      <th>Director</th>
      <th>Genre</th>
      <th>Date</th>
      <th>Rating</th>
    </tr>
  </thead>
   
  <tbody>
   <% for (int i=0; i<movies.size(); i++) {%>
   <tr>
   
      <% moviebean m=movies.get(i);%>
        <td>
            <small>
                   <%= m.getName() %>
            </small>
        </td>
         <td>
            <small>
                   <%= m.getMain_actor() %>
            </small>
        </td>
         <td>
            <small>
                   <%= m.getDirector() %>
            </small>
         <td>
            <small>
           <%= m.getGenre() %>
            </small>
        </td>
         <td>
            <small>
           <%= m.getRd_date() %>
            </small>
        </td>
        <td>
           <small>
           <%=m.getAverage()%>
           </small>
        </td>
      
   </tr>
   <% } %>
  </tbody>
   
   
 </table>
 
 <p>to rate any of the above mentioned movies please click on rate button</p>
    <form action ="rate.jsp">
          <input type ="submit" value="rate">
    </form>
    
  <p>to go back to registered webpage</p>
    <form action ="registered.jsp">
          <input type ="submit" value="Registered">
    </form>
 
        
 
 

</body>
</html>