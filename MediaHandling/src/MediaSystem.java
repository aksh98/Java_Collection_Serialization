import java.util.*;
import java.io.*;

public class MediaSystem
{	
	Set<Movie> Movies = new HashSet<Movie>();
	Set<Song> Songs = new HashSet<Song>();
	HashMap<String, List<String> > hm_songs = new HashMap<String, List<String> >();
	HashMap<String, List<String> > hm_movies = new HashMap<String, List<String> >();
	int numSongs,numMovies;
	public MediaSystem()
	{
		numSongs = 0;
		numMovies = 0;
	}
//------------------------------------------------------------------	
	void topKSongs(int k)
	{
		Set<Song> sorted = new TreeSet<Song>(Songs);
		Iterator<Song> i = sorted.iterator();
		int count = 1;
		Song S;
		while(count <= k && i.hasNext())
		{
			S = i.next();
			System.out.println(count + ". " + S.getTitle() + " : " + S.getRating());
			count++;
		}
		if(count <= k)
		{
			count -= 1;
			System.out.println("There were only " + count + " songs in library !");
		}
	}
//------------------------------------------------------------------	
	void topKMovies(int k)
	{
		Set<Movie> sorted = new TreeSet<Movie>(Movies);
		Iterator<Movie> i = sorted.iterator();
		int count = 1;
		Movie M;
		while(count <= k && i.hasNext())
		{
			M = i.next();
			System.out.println(count + ". " + M.getTitle() + " : " + M.getRating());
			count++;
		}
		if(count <= k)
		{
			count -= 1;
			System.out.println("There were only " + count + " movies in library !");
		}
	}
//-------------------------------------------------------------
	public void SerializeData()
	{
		BufferedReader br = null;
		try
		{ 
			String CurrentLine;
			br = new BufferedReader(new FileReader("song.txt"));
			while((CurrentLine = br.readLine()) != null)
			{
				Song song = new Song();
				List<String> asong = Arrays.asList(CurrentLine.split(","));
				song.title = asong.get(0);
				song.movieName = asong.get(1);
				song.artist = asong.get(2);
				song.yearOfRelease = Integer.valueOf(asong.get(3));
				song.genre = asong.get(4);
				song.size = Integer.valueOf(asong.get(5));
				song.rating = Integer.valueOf(asong.get(6));
				song.duration = asong.get(7);
				Songs.add(song);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			try{if(br!=null) br.close();}catch(Exception e){e.printStackTrace();}}
		int count=0;
		for(Song i : this.Songs)
		{
			SerializeSong(i);
			this.genreSort(i);
			count++;
		}
		this.numSongs = count;
		
		try
		{ 
			String CurrentLine;
			br = new BufferedReader(new FileReader("movie.txt"));
			while((CurrentLine = br.readLine()) != null)
			{
				Movie movie = new Movie();
				List<String> amovie = Arrays.asList(CurrentLine.split(","));
				movie.title = amovie.get(0);
				movie.artist = amovie.get(1);
				movie.yearOfRelease = Integer.valueOf(amovie.get(2));
				movie.genre = amovie.get(3);
				movie.size = Integer.valueOf(amovie.get(4));
				movie.rating = Integer.valueOf(amovie.get(5));
				movie.duration = amovie.get(6);
				movie.director = amovie.get(7);
				movie.producer = amovie.get(8);
				movie.certification = amovie.get(9);
				Movies.add(movie);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			try{if(br!=null) br.close();}catch(Exception e){e.printStackTrace();}}
		count=0;
		for(Movie i : this.Movies)
		{
			SerializeSong(i);
			this.sortDirector(i);
			count++;
		}
		this.numSongs = count;
		
	}
//--------------------------------------------------------------
	public void SerializeSong(Object song)
	{
		try
		{
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("song.dat"));
			out.writeObject(song);
			out.flush();
			out.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
//------------------------------------------------------------
	public Song DeserializeSong()
	{
		Song song = null;
		try
		{
			FileInputStream inp = new FileInputStream("song.dat");
			ObjectInputStream in = new ObjectInputStream(inp);
			song = (Song)in.readObject();
			in.close();inp.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return song;
	}
//---------------------------------------------------------
	public void genreSort(Song S)
	{
		String name = S.getTitle();
		String songGenre = S.getGenre();
		List<String> values = hm_songs.get(songGenre);
		if(values == null)
		{
			values = new ArrayList<String>();
			hm_songs.put(songGenre, values);
		}
		values.add(name);
	}
//---------------------------------------------------------
	public void sortDirector(Movie M)
	{
		String name = M.getTitle();
		String movieDirector = M.getDirector();
		List<String> values = hm_movies.get(movieDirector);
		if(values == null)
		{
			values = new ArrayList<String>();
			hm_movies.put(movieDirector,values);
		}
		values.add(name);
	}
//---------------------------------------------------------
	public static void main(String[] args)
	{
	
	}

}
