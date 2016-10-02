import java.io.Serializable;

public abstract class Media implements Serializable,Comparable<Object>{
	private static final long serialVersionUID = -524853310152172952L;
	protected String title;
	protected String artist;
	protected Integer yearOfRelease;
	protected String genre;
	protected Integer size;
	protected Integer rating;
	protected String duration;
//Constructor----------------------------------------------------
	public Media() {
		super();
		this.title = null;
		this.artist = "defaultArtist";
		this.yearOfRelease = null;
		this.genre = "defaultGenre";
		this.size = null;
		this.rating = null;
		this.duration = "0:00";
	}
//Setter-------------------------------------------------------------------------------
	void setRating(Integer newRating){
		System.out.println("Rating of "+this.title+" updated from "+this.rating+" to "+ newRating);
		this.rating = (int)newRating;}
// Getter------------------------------------------------------------------------------------------
	String getTitle(){ return this.title; }
	String getArtist(){ return this.artist; }
	String getGenre(){ return this.genre;}
	String getDuration(){ return this.duration;}
	Integer getSize(){ return this.size;}
	Integer getRating(){ return this.rating;}
	Integer getYear(){ return this.yearOfRelease;}
	
//@Override-----------------------------------------------------------------
	public int compareTo(Object other) {
		return this.rating.compareTo(((Media)other).getRating());
	}
	
//toString-----------------------------------------------------------------------
	public String toString(){
		return this.artist+","+this.yearOfRelease+","+this.genre+","+this.size+","+this.rating+","+this.duration+",";
	}
//Print it in the child class.	
	public String Display(){
		String string = "Artist: "+this.artist+"\nYear of Release: "+this.yearOfRelease +"\nGenre: "+this.genre +"\nSize:"+this.size+"\nRating: "+this.rating+"\nDuration: "+this.duration+"\n";
		return string;
	}
}

class Movie extends Media{
	private static final long serialVersionUID = -643119179113208576L;
	
}
class Song extends Media{
	private static final long serialVersionUID = -675961048978951030L;
	String movieName;
	String getMovieName() { return this.movieName; }
		
	public String toString()
	{
		String res = this.title;
		res += this.movieName;
		res += super.toString();
		return res;
	}
	
}