package interfaces;

import java.sql.Date;
import java.util.ArrayList;

import dbadapter.moviebean;
import dbadapter.ratingbean;

public interface IMoviedatabase {
	public moviebean Addingmovie(String name, Date released_date, String genre, String director, String mainActor);
	public moviebean get_addmovie(String name,Date released_date,String genre,String director,String mainActor);
	public ArrayList<moviebean> get_movies();
	public boolean get_rating(String username,String moviename);
	public ratingbean addingrating(String username,String moviename,int rating);

}
