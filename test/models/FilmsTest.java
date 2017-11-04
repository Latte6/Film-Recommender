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
    one = new Films("James Bond", "2004", "007.com");
    two = new Films("Harry Potter", "2006", "potter.com");
  }
	
	
 @After
  public void tearDown()
  {
    one = two = null;
  }



@Test
public void testCreate()
{
	assertEquals ("James Bond", "2004", "007.com");
	assertEquals ("Harry Potter", "2006", "potter.com");
	 
		
}

@Test
public void testIds()
{
	assertNotEquals(one.FilmId, two.FilmId);
}


@Test
public void testToString()
{
	assertEquals ("Films{" + film[0].FilmId +" , James Bond , 2004 ,007.com}", film[0].toString());
}
}
