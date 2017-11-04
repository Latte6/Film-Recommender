package model;

import static com.google.common.base.MoreObjects.toStringHelper;

import java.util.ArrayList;

import com.google.common.base.Objects;

public class Rating {
		//Variables
	 public long Id;
	 static Long   counter = 0l;
	 
	 public Long userId;
	 public Long filmId ;
	 public double rating ;
	 
	 public ArrayList<Films> route = new ArrayList<Films>();
	 
	 
	 public Rating()
	 {
		 
	 }
	 //Constructor
	 
	public Rating(  Long userId, Long filmId, double rating) 	
	{
		this.userId = userId;
		this.filmId = filmId;
		this.rating = rating;
		this.Id = counter ++;
	}
	
	//ToString
	@Override
	public String toString()
	{
	  return toStringHelper(this).addValue(Id)
	                             .addValue(filmId)
	                             .addValue(userId)
	                             .addValue(rating)
	                             .toString();
	 
	 }
	
	//Hashcode
	@Override  
	public int hashCode()  
	{  
	   return Objects.hashCode(this.filmId, this.userId, this.rating, this.Id  );  
	}

	//Boolean
	@Override
	public boolean equals(final Object obj)
	{
		if(obj instanceof Rating)
		{
			final Rating other = (Rating) obj;
			return Objects.equal(filmId, other.filmId)
					&& Objects.equal(userId, other.userId)
					&& Objects.equal(rating, other.rating)
					&& Objects.equal(route, other.route);
		}
		else
		{
			return false;
		}
		
	}
	
}