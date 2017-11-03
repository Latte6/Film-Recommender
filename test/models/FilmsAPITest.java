package models;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controllers.FilmsAPI;
import model.User;

import static models.Fixtures.users;

public class FilmsAPITest {
	
	private FilmsAPI films;
	
	 @Before
	  public void setup()
	  {
	    films = new FilmsAPI();
	    for (User user : users)
	    {
	      films.createUser(user.fName, user.lName, user.Age, user.Gender , user.Job);
	    }
	  }
	 
	 @After
	  public void tearDown()
	  {
	    films = null;
	  }
	 
	 @Test
	  public void testUser()
	  {
	    assertEquals (users.length, films.getUsers().size());
	    films.createUser("homer", "simpson", "32", "Male", "Power Plant");
	    assertEquals (users.length+1, films.getUsers().size());
	    assertEquals (users[0], films.getUserByfName(users[0].fName));
	  }  
	 
	 @Test
	  public void testUsers()
	  {
	    assertEquals (users.length, films.getUsers().size());
	    for (User user: users)
	    {
	      User eachUser = films.getUserByfName(user.fName);
	      assertEquals (user, eachUser);
	      assertNotSame(user, eachUser);
	    }
	  }
	 
	 @Test
	  public void testDeleteUsers()
	  {
	    assertEquals (users.length, films.getUsers().size());
	    User marge = films.getUserByfName("marge");
	    films.deleteUser(marge.UserId);
	    assertEquals (users.length-1, films.getUsers().size());    
	  }  
	 
}
	 
	 
	 