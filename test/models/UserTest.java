package models;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;
import model.User;

import static models.Fixtures.users;

public class UserTest
{
  User homer = new User ("homer", "simpson", "32",  "male", "power plant");

  @Test
  public void testCreate()
  {
    assertEquals ("homer",               homer.fName);
    assertEquals ("simpson",             homer.lName);
    assertEquals ("32",                  homer.Age);   
    assertEquals ("male",                homer.Gender);
    assertEquals ("power plant",         homer.Job);
  }

  @Test
  public void testIds()
  {
    Set<Long> ids = new HashSet<>();
    for (User user : users)
    {
      ids.add(user.UserId);
    }
    assertEquals (users.length, ids.size());
  }

  @Test
  public void testToString()
  {
    assertEquals ("User{" + homer.UserId + ", homer, simpson, 32, male , power plant}", homer.toString());
  }
}