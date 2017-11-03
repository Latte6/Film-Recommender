package controllers;

import java.io.File;
import java.util.Collection;
import com.google.common.base.Optional;

import model.Films;
import model.User;
import utils.Serializer;
import utils.XMLSerializer;

public class Main
{
		public FilmsAPI film;
	
	public Main() throws Exception {
		File films = new File ("datastore.xml");
		Serializer serializer = new XMLSerializer(films);
		film = new FilmsAPI(serializer);
		if(films.isFile())
		{
			film.load();
		}
	}
	
	public static void Menu()
	{
		System.out.println("1. Create User");
		System.out.println("2. Get User by First Name");
		System.out.println("3  delete User");
		System.out.println("4. Add Movie");
		System.out.println("5. Add Ratings");
		System.out.println("6. Store");
		System.out.println("7. Exit");
		
	}
	
	public static void main(String[] args) throws Exception 
	{
		Main api = new Main();
		String /* users*/fName, lName, gender, age, job,/* movies*/ name, date, link ;
		
		long /*ratings*/ filmId , UserId;;
		int choice=0;
		double /*ratings*/rateingLeft;
		char answer;
		
	
	api.film.initalLoad();
	do {
		Menu();
		System.out.println("Please select an option between 1-7: ");
		choice= EasyScanner.nextInt();
		
		switch (choice)
		{
		case 1:
			   System.out.println("Enter your first name: ");
		       fName = EasyScanner.nextString();
		       
		       System.out.println("Enter your last name: ");
		       lName = EasyScanner.nextString();
		       
		       System.out.println("Enter your age: ");
		       age = EasyScanner.nextString();
		       
		       System.out.println("Enter your gender: ");
		       gender = EasyScanner.nextString();
		       
		       System.out.println("Enter your job: ");
		       job = EasyScanner.nextString();
		       
		       api.addUser(fName, lName, age, gender, job);
		       api.film.store();		     			       
		break;
		
		case 2:
			 System.out.println("Get user by name: ");
			 fName = EasyScanner.nextString();
	         api.getUserByfName(fName);
	         api.getAllUsers();
		break;
		
		case 3:
			  System.out.println("Please enter the name of who you want to remove: ");
		      fName = EasyScanner.nextString();
		      api.deleteUser(fName);
		      
		break;
		
		case 4:			
			   System.out.println("Enter the movie Id: ");
		       filmId = EasyScanner.nextLong();
		       
			   System.out.println("Enter the movie Title: ");
		       name = EasyScanner.nextString();
		        
		       System.out.println("Enter date movie was releasd: ");
		       date = EasyScanner.nextString();
		       
		       System.out.println("Enter url link of movie: ");
		       link = EasyScanner.nextString();
		       
		       api.addFilm(filmId, name, date, link);
		       api.film.store();	
		break;
				
		case 5:		     
			   System.out.println("Enter your user ID: ");
		       UserId = EasyScanner.nextLong();
		       
		       System.out.println("Enter movie ID: ");
		       filmId = EasyScanner.nextLong();
		        
		       System.out.println("Enter ratings: ");
		       rateingLeft = EasyScanner.nextDouble();
		       
		       api.addRatings(UserId, filmId,  rateingLeft);
		break;
			
		case 6:
			 System.out.println("Would you like to store the data entered? [y/n]: ");
			 answer = EasyScanner.nextChar();
			 if (answer == 'y' || answer == 'Y')
			 {
				 api.film.store();
			 }
		break;
			
		case 7:
			 System.out.println("Thank you. Goodbye");
		break;
			
		default:
			 System.out.println("Please ONLY choose options 1-7 .Thank you");
		break;
		}
		
	}while(choice!=7);
	
}

	private void addRatings(long UserId, long movieId, double rateingLeft) {
		Optional<Films> ratings = Optional.fromNullable(film.getMovie(movieId));
		if(ratings.isPresent())
		{
			film.createRating( UserId,movieId, rateingLeft);
		}
		
	}

	private void deleteUser(String fName) {
		Optional<User> user = Optional.fromNullable(film.getUserByfName(fName));
		if(user.isPresent())
		{
			film.deleteUser(user.get().UserId);
		}
		
	}

	private void getAllUsers() {
		Collection<User> user = film.getUsers();
		System.out.println(user);
	}

	private void getUserByfName(String fName) {
		User user = film.getUserByfName(fName);
		System.out.println(user);
		
	}

	private void addUser(String fName, String lName, String age, String gender, String job) {
		film.createUser(fName, lName, age, gender, job);
		
	}

	private void addFilm(long Id, String name, String date, String link) {
		Optional<User> movies = Optional.fromNullable(film.getUser(Id));
		if(movies.isPresent())
		{
			film.addMovie(Id, name, date, link);
		}
		
	}
}
