import java.io.Serializable;

public class Media implements Serializable,Comparable<Object>{
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
	void setTitle(String title){ this.title = title;}
	void setArtist(String Artist){this.artist = Artist;}
	void setYear(Integer year){this.yearOfRelease = year;}
	void setGenre(String genre){this.genre = genre;}
	void setSize(Integer size){this.size = size;}
	void setDuration(String dur){this.duration = dur;}
	void setRating(Integer newRating){
		System.out.println("Rating of "+this.title+" updated from "+this.rating+" to "+ newRating);
		this.rating = newRating;}
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
		String res = "Artist : " + this.artist;
		res += "\nYear of Release : " + this.yearOfRelease;
		res += "\nGenre : " + this.genre;
		res += "\nSize : " + this.size;
		res += "\nRating : " + this.rating;
		res += "\nDuration(hrs) : " + this.duration;
		return res;
	}
}


class Movie extends Media
{
	private static final long serialVersionUID = -643119179113208576L;
	private String director;
	private String producer;
	private String certification;
	void setDirector(String dir){ this.director = dir;}
	void setProducer(String prod){this.producer = prod;}
	void setCertification(String Cert){this.certification= Cert;}
	String getDirector() { return this.director; }
	String getProducer() { return this.producer; }
	String getCertification() {return this.certification; }
	public String toString()
	{
		String res = "Title: " + this.title + "\n";
		res += super.toString();
		res = res +  "Director : " + this.director;
		res += "\nProducer : " + this.producer; 
		res += "\bCeritifaction : " + this.certification + "\n";
		return res;
	}
}
class Song extends Media{
	private static final long serialVersionUID = -675961048978951030L;
	private String movieName;
	String getMovieName() { return this.movieName; }
	void setMovieName(String mName){this.movieName = mName;}
	public String toString()
	{
		String res = "Title: " + this.title + "\n";
		res += "Movie Name : " +  this.movieName + "\n";
		res += super.toString();
		return res;
	}
	
}