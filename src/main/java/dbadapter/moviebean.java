package dbadapter;

import java.sql.Date;



public class moviebean {
	
	private String name;
	private Date rd_date;
	private String genre;
	private String director;
	private String main_actor;
	private float average;
	
	public float getAverage() {
		return average;
	}
	public void setAverage(float average) {
		this.average = average;
	}
	
	public moviebean(String name, Date rd_date, String genre, String director, String main_actor,float average) {
		super();
		this.name = name;
		this.rd_date = rd_date;
		this.genre = genre;
		this.director = director;
		this.main_actor = main_actor;
		this.average = average;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getRd_date() {
		return rd_date;
	}
	public void setRd_date(Date rd_date) {
		this.rd_date = rd_date;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getMain_actor() {
		return main_actor;
	}
	public void setMain_actor(String main_actor) {
		this.main_actor = main_actor;
	}
	
	
	
	
	

}
