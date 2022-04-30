package dbadapter;

public class ratingbean {
	private String moviename;
	private String username;
	private int rating;
	
	
	
	public ratingbean(String moviename, String username, int rating) {
		super();
		this.moviename = moviename;
		this.username = username;
		this.rating = rating;
	}
	
	public String getMoviename() {
		return moviename;
	}
	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	

}
