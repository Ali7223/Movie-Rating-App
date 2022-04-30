package interfaces;

import java.sql.Date;
import java.util.ArrayList;

import dbadapter.moviebean;
import dbadapter.ratingbean;
import dbadapter.userbean;

public interface UCmds {
	//registration
	
	public userbean makeaccount(userbean user) ;
	
	//Add movie
	
	public boolean createmovie(String name,String released_date,String genre,String director,String mainActor);
    
	//Browse and MovieRating
	
	public ArrayList<moviebean> searchmovies();
	
	public ratingbean createrating(String username,String moviename,String rating);

	
	
}
