package Servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import application.MRApp;
import dbadapter.moviebean;
import dbadapter.ratingbean;
import dbadapter.userbean;

/**
 * Servlet implementation class UserGui
 */

public class UserGui extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//browse movie if and else if clauses are same because my browser not picking up action attribute from the form for get methods
		String action = (request.getParameter("action") == null) ? "" : request.getParameter("action");
		
		if (action.equals("")) {
		
			ArrayList<moviebean> availablemovies = null;
			
			
			availablemovies=MRApp.getInstance().searchmovies();
			
			if(availablemovies!=null) {
			// Dispatch request to template engine
			  request.setAttribute("list", availablemovies);
			  try {
				request.getRequestDispatcher("movieListRepresentation.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			}
			else {
				response.getWriter().println("No movies in the data base");
			}
		
		}
		
		
}




	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	//register user
		if(request.getParameter("action").equals("register")) {
			
			int age =Integer.parseInt(request.getParameter("age"));
			userbean check=null;
			request.setAttribute("navtype", "register");
			 HttpSession session=request.getSession();
	    	  session.setAttribute("name", request.getParameter("username"));
			
			if (age>=18) {
				
				userbean user=new userbean(request.getParameter("username"),request.getParameter("email"),age );
				check=MRApp.getInstance().makeaccount(user);
			      if(check!=null){
			    	 
			    	  request.setAttribute("message", "Registered Succesfully");
			    	  
			    try {
			    	request.getRequestDispatcher("successRepresentaion.jsp").forward(request, response);
			    }catch(Exception e) {
			    	e.printStackTrace();
			    }
				
			    	  
			
			}  else {
				request.getRequestDispatcher("errorRepresentation.jsp?message=username_already_exists").forward(request, response);
			}
			}
			else {
				response.getWriter().println("age below 18 not allowed");
		}
			
}
		
	//rate movie	
	else if (request.getParameter("action").equals("rate")) {
		
		HttpSession session=request.getSession();
		String username =(String)session.getAttribute("name");
		request.setAttribute("navtype", "rate");
		ratingbean rs=MRApp.getInstance().createrating(username, request.getParameter("name"),request.getParameter("rating"));
		if(rs!=null){
			try {
				
				request.getRequestDispatcher("successRepresentaion.jsp").forward(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else{
			request.getRequestDispatcher("errorRepresentation.jsp").forward(request, response);
		}
		
	}
	
	
		
	//Add Movie code
	
	else if (request.getParameter("action").equals("addmovie")) {
		
		
		
		boolean res;
		
		res=MRApp.getInstance().createmovie(request.getParameter("name"),request.getParameter("date"),request.getParameter("genre"),
				request.getParameter("director"),request.getParameter("main_actor"));
		
		request.setAttribute("navtype", "addmovie" );
		
		     if(res==false) {
		    	request.getRequestDispatcher("errorRepresentation.jsp").forward(request, response);
		    
		    }
		     else {
		    	 request.setAttribute("message", "movieadded Successfully" );
		    	 request.getRequestDispatcher("successRepresentaion.jsp").forward(request,response);
		    	
		     }
		    	 
		
	}
	
	}
		
	}




