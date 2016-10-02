import java.util.*;
import java.io.*;

public class MediaSystem
{	
	Set<Movie> Movies = new HashSet<Movie>();
	Set<Song> Songs = new HashSet<Song>();
	HashMap<String, String> hm = new HashMap<String, String>();
	
	int numSongs,numMovies;
	public MediaSystem()
	{
		numSongs = 0;
		numMovies = 0;
	}
//------------------------------------------------------------------	
	void topKSongs(int k)
	{
		Set sorted = new TreeSet<Song>(Songs);
		int j = sorted.size()-k;
		for(int i=sorted.size();i>j;i--)
		{
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
			this.hm.put(i.genre,i.title);
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
	public static void main(String[] args)
	{
	
	}

}
