package model;

import static com.google.common.base.MoreObjects.toStringHelper;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Objects;

public class Films {

public long FilmId;
public static Long   counter = 0l;
public String date;
public String link;
public String Name;
	
	
 public List<Rating> film  = new ArrayList<>();
	 
	

public Films( String name, String date, String link) {
	
	this.FilmId = counter ++;
	this.Name = name;
	this.date = date;
	this.link = link;
	}
	 
	@Override
	public String toString()
	{
	  return toStringHelper(this).addValue(Name)
	                             .addValue(date)
	                             .addValue(link)
	                             .addValue(FilmId)
	                             .toString();
	 
	 }
	
	@Override  
	public int hashCode()  
	{  
	   return Objects.hashCode(this.Name, this.date, this.link, this.FilmId  );  
	}

	@Override  
	public boolean equals(final Object obj)
	{
		if (obj instanceof Films)
		{
			final Films other = (Films) obj;
			return Objects.equal(Name, other.Name)
					&& Objects.equal(date, other.date)
					&& Objects.equal(link, other.link);
		}
		else
		{
			return false;
		}
	}
		
	}
	
