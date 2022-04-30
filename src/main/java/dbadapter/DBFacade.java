package dbadapter;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.IMoviedatabase;
import interfaces.IUserdatbase;

public class DBFacade implements IUserdatbase, IMoviedatabase{
	
	private static DBFacade instance;

	
	private DBFacade() {
		try {
			Class.forName("com." + Configuration.getType() + ".jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static DBFacade getInstance()  {
		if (instance == null) {
			instance = new DBFacade();
		}
		return instance;
	}

	public static void setInstance(DBFacade dbfacade) {
		instance = dbfacade;
	}
	//Code for Entering user Account data into the database
	
	
	public userbean CreatingAccount(String username,String Email,int age) {
		userbean post=null;
		
		String sqlInsert = "insert into userdatabase(username,email,age) values (?,?,?)";
		String checkpostcon="Select * from userdatabase where username=? and email=? and age=?";
		
		try(Connection conn =DriverManager.getConnection("jdbc:" + Configuration.getType() + "://" + Configuration.getServer() + ":"
				+ Configuration.getPort() + "/" + Configuration.getDatabase() , Configuration.getUser(), Configuration.getPassword()))
		{
			
			try(PreparedStatement ps=conn.prepareStatement(sqlInsert);
					PreparedStatement pscon=conn.prepareStatement(checkpostcon)){
				
				ps.setString(1, username);
				ps.setString(2, Email);
				ps.setInt(3, age);
				ps.executeUpdate();
				pscon.setString(1, username);
				pscon.setString(2, Email);
				pscon.setInt(3, age);
				try(ResultSet rs=pscon.executeQuery()){
				      if(rs.next()) {
				    	  post=new userbean(rs.getString(1), rs.getString(2), rs.getInt(3));
				      }
				}
				
			
				}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		catch(Exception e) {
				e.printStackTrace();
		}
		
	
		return post;
}

	//testing code
	
	
	public boolean get_loginusername(String name, String password) {
		
		boolean res=false;
		String sqlquery="select * from userdatabase where username=? and password=?";
		try(Connection conn =DriverManager.getConnection("jdbc:" + Configuration.getType() + "://" + Configuration.getServer() + ":"
				+ Configuration.getPort() + "/" + Configuration.getDatabase() , Configuration.getUser(), Configuration.getPassword())){
			try(PreparedStatement ps=conn.prepareStatement(sqlquery)){
				ps.setString(1, name);
				ps.setString(2, password);
			
				try (ResultSet rs = ps.executeQuery()){
					if(rs.next()) {
						res=true;
						
					}
							
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		
	    }
		
		return res;
		
		
	}
	
	//code for adding movie

	@Override
	public moviebean Addingmovie(String name, Date released_date, String genre, String director, String mainActor) {
		
		moviebean m=null;
		String sqlinsert="insert into moviedatabase(name,released_date,genre,director,mainActor) values(?,?,?,?,?)";
		String sqlpost="select * from moviedatabase where name=?";
		
		try(Connection conn=DriverManager.getConnection("jdbc:" + Configuration.getType() +"://" + Configuration.getServer() +
		    ":" + Configuration.getPort() + "/" + Configuration.getDatabase(), Configuration.getUser(), Configuration.getPassword())){
			try(PreparedStatement ps =conn.prepareStatement(sqlinsert);
					PreparedStatement pspost=conn.prepareStatement(sqlpost)){
				ps.setString(1, name);
				ps.setDate(2, released_date);
				ps.setString(3, genre);
				ps.setString(4, director);
				ps.setString(5, mainActor);
				try {
					ps.executeUpdate();
				}catch (Exception e) {
					return m;
				}
				
				pspost.setString(1, name);
				try(ResultSet rs=pspost.executeQuery()){
					if(rs.next()) {
						m=new moviebean(rs.getString(1),rs.getDate(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getFloat(6));
					}
					
				}
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return m;
	}

	
	//get movie name if its there
	@Override
	public moviebean get_addmovie(String name, Date released_date, String genre, String director, String mainActor) {
		
		moviebean m=null;
		
		String sqlquery="Select * from moviedatabase where name=? ";
		
		try(Connection conn=DriverManager.getConnection("jdbc:" + Configuration.getType() + "://" + Configuration.getServer() + ":" 
		                    + Configuration.getPort() + "/" + Configuration.getDatabase(), Configuration.getUser(),Configuration.getPassword())){
			try(PreparedStatement ps=conn.prepareStatement(sqlquery)){
			    ps.setString(1, name);
			    try(ResultSet rs=ps.executeQuery()){
			    	if(rs.next()) {
			    	
			    		m=new moviebean(rs.getString(1), rs.getDate(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getFloat(6));
			    		
			    		}
			    }
			}catch(SQLException e){
				e.printStackTrace();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return m;
	}
	
	//get_addmovie finishes

	@Override
	public ArrayList<moviebean> get_movies() {
		ArrayList<moviebean> movielist=new ArrayList<>();
		String sqlselect="select * from moviedatabase";
		
		try(Connection conn =DriverManager.getConnection("jdbc:" + Configuration.getType() + "://" + Configuration.getServer() + ":"
				+ Configuration.getPort() + "/" + Configuration.getDatabase() , Configuration.getUser(), Configuration.getPassword())){
			try(PreparedStatement ps=conn.prepareStatement(sqlselect)){
				try(ResultSet rs=ps.executeQuery()){
					while(rs.next()) {
						moviebean m=new moviebean(rs.getString(1),rs.getDate(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getFloat(6));
						movielist.add(m);
					    }
						
				}
			}catch(SQLException e) {
					e.printStackTrace();
				}
		}catch(Exception e) {
				e.printStackTrace();
	     }
		
	    return movielist;
	}
	
	@Override
	public boolean get_rating(String username,String moviename) {
		//check if the movie is already rated by the user before
		boolean res=false;
		String sqlcheck="SELECT CASE WHEN EXISTS (SELECT moviename FROM rating WHERE moviename =? and username =?) THEN 'TRUE' ELSE 'FALSE' END";
		try(Connection conn =DriverManager.getConnection("jdbc:" + Configuration.getType() + "://" + Configuration.getServer() + ":"
				+ Configuration.getPort() + "/" + Configuration.getDatabase() , Configuration.getUser(), Configuration.getPassword())){
			try(PreparedStatement ps=conn.prepareStatement(sqlcheck)){
				ps.setString(1, moviename);
				ps.setString(2, username);
				try(ResultSet rs= ps.executeQuery()){
					if(rs.next())
						if(rs.getBoolean(1)==true) {
							res=true;
						}
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}

//if the user already exist in the database if the user exist the method returns false otherwise true
	
public boolean get_Username(String name,String email,int age)
{
	boolean res=false;
	String sqlquery="select * from userdatabase where username=? and email=? and age=?";
	try(Connection conn =DriverManager.getConnection("jdbc:" + Configuration.getType() + "://" + Configuration.getServer() + ":"
			+ Configuration.getPort() + "/" + Configuration.getDatabase() , Configuration.getUser(), Configuration.getPassword())){
		try(PreparedStatement ps=conn.prepareStatement(sqlquery)){
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setInt(3, age);
			try (ResultSet rs = ps.executeQuery()){
				if(!rs.next())
					res=true;
										
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
	}
	catch(Exception e) {
		e.printStackTrace();
	
    }
	
	return res;
}


//rating is being added after confirming if the user has rated the movie before
@Override
public ratingbean addingrating(String username, String moviename, int rating) {
	ratingbean postcon=null;

	String sqlInsert = "insert into rating(moviename,username,rate) values (?,?,?)";
	//post condition query
	String sqlcon="select * from rating where moviename=? and username =? and rate=?";
	String sqlmovieAI="update moviedatabase set avg_rating = (select avg(rate) from rating where moviename =?) where name =?";
	
	try(Connection conn =DriverManager.getConnection("jdbc:" + Configuration.getType() + "://" + Configuration.getServer() + ":"
			+ Configuration.getPort() + "/" + Configuration.getDatabase() , Configuration.getUser(), Configuration.getPassword()))
	{
		
		try(PreparedStatement ps=conn.prepareStatement(sqlInsert);
			  PreparedStatement psq=conn.prepareStatement(sqlcon);
				PreparedStatement psqt=conn.prepareStatement(sqlmovieAI)){
			
			ps.setString(1, moviename);
			ps.setString(2, username);
			ps.setInt(3, rating);
			try {
			ps.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
		             System.out.println("movie does not exist");
			}
			psq.setString(1, moviename);
			psq.setString(2, username);
			psq.setInt(3, rating);
			try(ResultSet rs=psq.executeQuery()){
				if(rs.next()) {
					//checking postcondition
					postcon=new ratingbean(rs.getString(1),rs.getString(2),rs.getInt(3));
					psqt.setString(1,moviename);
					psqt.setString(2, moviename);
					psqt.executeUpdate();
					return postcon;
					
				}
		}
		
			}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	catch(Exception e) {
			e.printStackTrace();
	}
	return postcon;
}



}





