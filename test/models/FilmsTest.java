package models;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Films;

import static models.Fixtures.film;


public class FilmsTest {
	
	 private Films one;
	  private Films two;
	
	  @Before
	  public void setup()
	  {
	    one = new Films("cars 2", "2005", "cars2.com");
	    two = new Films("the green mile", "1998", "greenmile.com");
	  }
	
	
	 @After
	  public void tearDown()
	  {
	    one = two = null;
	  }

	

	@Test
	public void testCreate()
	{
		assertEquals ("cars 2", "2005", "cars2.com");
		assertEquals ("the green mile", "1998", "greenmile.com");
		 
		
	}
	
	@Test
	public void testIds()
	{
		assertNotEquals(one.FilmId, two.FilmId);
	}

	
	@Test
	public void testToString()
	{
		assertEquals ("Films{" + film[0].FilmId +" , cars 2 , 2005 ,cars2.com}", film[0].toString());
	}
}
