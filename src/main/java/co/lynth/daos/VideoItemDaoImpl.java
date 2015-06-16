package co.lynth.daos;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.lynth.models.VideoItem;

@Transactional
@Component
public class VideoItemDaoImpl implements VideoItemDao {


	private JdbcTemplate jdbcTemplate;
		
	public VideoItemDaoImpl(DataSource dataSource){
			
		jdbcTemplate = new JdbcTemplate(dataSource);
			
	}
	
	public VideoItemDaoImpl(){
					
	}
	
	@Override
	public void saveOrUpdate(VideoItem videoItem) {
		if (videoItem.getId() > 0) {
	        // update
	        String sql = "UPDATE videoItem SET serialnumber=? ,videoid=?, customerid=? WHERE id=?";
	        jdbcTemplate.update(sql,videoItem.getSerialNumber(),videoItem.getVideoId(),
	        													videoItem.getCustomerId(),
	        													videoItem.getId());
	    } else {
	        // insert
	        String sql = "INSERT INTO videoItem (serialnumber, videoid,customerid) VALUES (?,?,?)";
	        jdbcTemplate.update(sql, videoItem.getSerialNumber(),videoItem.getVideoId(),
					videoItem.getCustomerId());
	    }

	}

	@Override
	public void delete(int videoId) {
		String sql = "DELETE FROM videoId WHERE id=?";
		jdbcTemplate.update(sql, videoId);

	}

	@Override
	public VideoItem get(int videoId) {
			
		String sql = "SELECT * FROM videoitem WHERE id= " + videoId;
		RowMapper<VideoItem> r = (ResultSet rs, int rowNum) -> new VideoItem(rs.getInt("id"),
																	rs.getString("serialnumber"),
																	rs.getInt("videoid"),
																	rs.getInt("customerid"),
																	rs.getTimestamp("CreateDate"));
		
		List<VideoItem> listVideo = jdbcTemplate.query(sql, r);
			
		return listVideo.get(0);
	}

	@Override
	public List<VideoItem> list() {
		String sql = "SELECT * FROM videoitem";
				
		RowMapper<VideoItem> r = (ResultSet rs, int rowNum) -> new VideoItem(rs.getInt("id"),
																			rs.getString("serialnumber"),
																			rs.getInt("videoid"),
																			rs.getInt("customerid"),
																			rs.getTimestamp("CreateDate"));
			
		List<VideoItem> listVideoItem = jdbcTemplate.query(sql, r);
			
	    return listVideoItem;
			
	}

}
