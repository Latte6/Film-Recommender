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
	
	//Main run
	public static void main(String[] args) throws Exception 
	{
		Main api = new Main();
		
		//Variables for user
		String fName ;
		String lName;
		String gender;
		String age;
		String job;
		
		//Variables for film
		String name;
		String date;
		String link;
		
		//Variables for rating
		
		long  filmId; 
		long UserId;
		int choice=0;
		double rating;
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
			 System.out.println("Get user by their first name: ");
			 fName = EasyScanner.nextString();
	         api.getUserByfName(fName);
	         api.getAllUsers();
		break;
		
		case 3:
			  System.out.println("Please type in the first name of user you wish to remove: ");
		      fName = EasyScanner.nextString();
		      api.deleteUser(fName);
		      
		break;
		
		case 4:			
			   System.out.println("Enter the film Unique Identifiquer: ");
		       filmId = EasyScanner.nextLong();
		       
			   System.out.println("Enter the title of the film: ");
		       name = EasyScanner.nextString();
		        
		       System.out.println("Enter the date the film was realeased [dd/mmm/yyy]: ");
		       date = EasyScanner.nextString();
		       
		       System.out.println("Enter url link of the film you wish to add: ");
		       link = EasyScanner.nextString();
		       
		       api.addFilm(filmId, name, date, link);
		       api.film.store();	
		break;
				
		case 5:		     
			   System.out.println("Enter your user Unique Identifiquer: ");
		       UserId = EasyScanner.nextLong();
		       
		       System.out.println("Enter film Unique Identifiquer: ");
		       filmId = EasyScanner.nextLong();
		        
		       System.out.println("Enter rating: ");
		       rating = EasyScanner.nextDouble();
		       
		       api.addRatings(UserId, filmId,  rating);
		break;
			
		case 6:
			 System.out.println("Would you like to save current data entered? Type Yes[Y/N]No: ");
			 answer = EasyScanner.nextChar();
			 if (answer == 'y' || answer == 'Y')
			 {
				 api.film.store();
			 }
		break;
			
		case 7:
			 System.out.println("Thank you for using this awesome system, hope to see you again.");
		break;
			
		default:
			 System.out.println("Please choose of one of the following options 1-7.");
		break;
		}
		
	}while(choice!=7);
	
}

	//Creating Rating
	private void addRatings(long UserId, long movieId, double rateingLeft) {
		Optional<Films> ratings = Optional.fromNullable(film.getMovie(movieId));
		if(ratings.isPresent())
		{
			film.createRating( UserId,movieId, rateingLeft);
		}
		
	}

	//Removing user
	private void deleteUser(String fName) {
		Optional<User> user = Optional.fromNullable(film.getUserByfName(fName));
		if(user.isPresent())
		{
			film.deleteUser(user.get().UserId);
		}
		
	}

	//Getting all users
	private void getAllUsers() {
		Collection<User> user = film.getUsers();
		System.out.println(user);
	}

	//Getting User by first name
	private void getUserByfName(String fName) {
		User user = film.getUserByfName(fName);
		System.out.println(user);
		
	}

	//Adding user
	private void addUser(String fName, String lName, String age, String gender, String job) {
		film.createUser(fName, lName, age, gender, job);
		
	}

	//Adding film
	private void addFilm(long Id, String name, String date, String link) {
		Optional<User> movies = Optional.fromNullable(film.getUser(Id));
		if(movies.isPresent())
		{
			film.addMovie(Id, name, date, link);
		}
		
	}

	//Menu
		public static void Menu()
		{
			System.out.println("1. Create User");
			System.out.println("2. Get User by First Name");
			System.out.println("3  Remove User");
			System.out.println("4. Add Film");
			System.out.println("5. Add Ratings");
			System.out.println("6. Store/Save");
			System.out.println("7. Exit");
			
		}
}
