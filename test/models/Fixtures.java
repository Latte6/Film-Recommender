package models;

import model.Films;
import model.Rating;
import model.User;

public class Fixtures
{
  public static User[] users =
  {
    new User ("marge", "simpson", "30",  "female", "kitchen worker"),
    new User ("lisa",  "simpson", "10",   "female", "schoolie"),
    new User ("bart",  "simpson", "12", "male", "schoolie"),
    new User ("maggie","simpson", "1", "femalet", "child")
  };
  
  
  public static Rating[] ratings = 
	  {
			  new Rating (0l,001l,5),
			  new Rating (02l,002l,3),
			  new Rating (03l,003l,4),
			  new Rating (04l,004l, 3),
			  new Rating (05l, 005l, 2),
			  
	  };
  
  public static Films[] film = 
	  {
			 new Films("toy story","1998","toy.com"), 
			 new Films("mulan","2000","mulan.com"), 
			 new Films("antz","2007","antz.com"), 
			 new Films("flubber","1998","flubber.com"), 
			 new Films("cars","2004","cars.com"), 
			 
	  };
			  
			  
			  
	  }
  
  
  
  
  
  
  
  
  
  
