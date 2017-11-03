package controllers;

import model.Films;
import model.Rating;
import model.User;

public interface FilmAPIInterface {
	public User createUser(String fName, String lName, String age, String gender, String job ); 
	public void deleteUser(Long userID);
	public Films addMovie(long id, String name, String date, String link);
	public Rating createRating(Long ID, Long filmID, double rating);
	public Films getMovie(Long iD);
	
	//public void load(File file) throws Exception;
	//public void write();
	
	
}
