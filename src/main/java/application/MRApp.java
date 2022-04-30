package application;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import dbadapter.DBFacade;
import dbadapter.moviebean;
import dbadapter.ratingbean;
import dbadapter.userbean;
import interfaces.UCmds;


public class MRApp implements UCmds{
	
	private static MRApp instance;
	
	public static MRApp getInstance() {
		if (instance == null) {
			instance = new MRApp();
		}

		return instance;
	}
	
	public boolean loginusername(String name, String password) {
		if(DBFacade.getInstance().get_loginusername(name,password)) {
			return true;
		}
			
		else
			return false;
		
	}
	
	public userbean makeaccount(userbean user) {
		
		
		
		//this method checks first if username with same name,email and age exist , if not then it creates an account and tuck it in the database
		userbean res=null;
		if(DBFacade.getInstance().get_Username(user.getUsername(), user.getEmail(), user.getAge())) {
		res=DBFacade.getInstance().CreatingAccount(user.getUsername(), user.getEmail(), user.getAge());
		}
		return res;
	}


	public boolean createmovie(String name, String rd_date, String genre, String director,String mainActor){
		
		moviebean res=null;
		boolean flag=true;
		java.sql.Date date=java.sql.Date.valueOf(rd_date);
		res=DBFacade.getInstance().get_addmovie(name, date, genre, director, mainActor);
		if(res!=null) {
			flag=false;
			return flag;
		}
		moviebean postresult=DBFacade.getInstance().Addingmovie(name,date,genre,director,mainActor);
 		if(postresult==null) {
 			flag=false;
			return flag;
 		}
		return flag;
	}
	

	@Override
	public ArrayList<moviebean> searchmovies() {
		ArrayList<moviebean> movies = null;
		movies=DBFacade.getInstance().get_movies();
		return movies;
	}

	@Override
	public ratingbean createrating(String username,String moviename, String rating) {
		int rat=Integer.parseInt(rating);
		ratingbean res=null;
		//if its not rated by the user before
		if(!DBFacade.getInstance().get_rating(username,moviename))
		    res=DBFacade.getInstance().addingrating(username, moviename, rat) ;
			   
	
		return res;
	}
	

	
	
	
	

}
