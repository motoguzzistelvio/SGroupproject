package co.lynth.daos;

import java.util.List;

import org.springframework.stereotype.Component;

import co.lynth.models.Genre;
import co.lynth.models.SearchObject;
import co.lynth.models.Video;
@Component
public interface VideoDao {
	
	 public void saveOrUpdate(Video video);
     
	 public void delete(int videoId);
	     
	 public Video get(int videoId);
	     
	 public List<Video> list();
	 
	 public List<SearchObject> searchVideo();
	 
	 public List<Genre> getGenres();

}
