package model;
import static com.google.common.base.MoreObjects.toStringHelper;

import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Objects;


public class User {
	//Variables for User
	 public String fName;
	 public String lName;
	 public String Age;
	 public String Gender;
	 public String Job ;
	 public long UserId;
	 public static Long   counter = 0l;
 
	 //Map
	 public Map<Long , Films> movies = new HashMap<Long , Films>();
 
	 public User() {

 }

	 //Construcotr
	 public User(String fName, String lName, String age, String gender, String job ) {
	
	this.fName = fName;
	this.lName = lName;
	this.Age = age;
	this.Gender = gender;
	this.Job = job;
	this.UserId = counter++ ;
}
	 //ToString
@Override
	public String toString()
{
  return toStringHelper(this).addValue(fName)
                             .addValue(lName)
                             .addValue(Age)
                             .addValue(Gender)   
                             .addValue(Job) 
                             .addValue(UserId) 
                             .toString();
}

	//Hashcode
@Override  
	public int hashCode()  
{  
   return Objects.hashCode(this.fName, this.lName, this.Age, this.Gender , this.Job);  
}

	//Boolean
@Override  
	public boolean equals(final Object obj)
{
	if (obj instanceof User)
	{
		final User other = (User) obj;
		return Objects.equal(fName, other.fName)
				&& Objects.equal(lName, other.lName)
				&& Objects.equal(Age, other.Age)
				&& Objects.equal(Gender, other.Gender)
				&& Objects.equal(Job, other.Job)
				&& Objects.equal(UserId, other.UserId);
	}
	else
	{
		return false;
	}
}

	}
