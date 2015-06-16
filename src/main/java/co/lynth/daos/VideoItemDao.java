package co.lynth.daos;

import java.util.List;

import org.springframework.stereotype.Component;

import co.lynth.models.VideoItem;

@Component
public interface VideoItemDao {
	
	 public void saveOrUpdate(VideoItem videoItem);
     
	 public void delete(int videoItemId);
	     
	 public VideoItem get(int videoItemId);
	     
	 public List<VideoItem> list();

}
