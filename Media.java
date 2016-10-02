public abstract class Media implements Comparable, Serializable
{
	
}

class Movie extends Media
{
	private String director;
	private String producer;
	private String certification;
	String getDirector() { return this.director; }
	String getProducer() { return this.producer; }
	String getCertification() {return this.certification; }
	String toString()
	{
		String res = this.title;
		res += super.toString();
		res = res +  this.director + "," + this.producer + "," + this.certification;
		return res;
	}
}

class Song extends Media
{
	private String movieName;
	String getMovieName() { return this.movieName; }
	String toString()
	{
		String res = this.title;
		res += this.movieName;
		res += super.toString();
	}
}