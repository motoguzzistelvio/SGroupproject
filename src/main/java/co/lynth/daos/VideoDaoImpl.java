package co.lynth.daos;

import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import co.lynth.models.Customer;
import co.lynth.models.Genre;
import co.lynth.models.SearchObject;
import co.lynth.models.Video;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Component
public class VideoDaoImpl implements VideoDao {

	private JdbcTemplate jdbcTemplate;
	
	public VideoDaoImpl(DataSource dataSource){
		
		jdbcTemplate = new JdbcTemplate(dataSource);
		
	}
	
	public VideoDaoImpl(){
		
	}
	
	@Override
	public void saveOrUpdate(Video video) {
		if (video.getId() > 0) {
	        // update
	        String sql = "UPDATE video SET name=?,genreId=?,minutes=?,actors=?,releasedate=?"
	        						+ " WHERE id=?";
	        jdbcTemplate.update(sql, video.getName(),
	        						 video.getGenreId(),
	        						 video.getMinutes(),
	        						 video.getActors(),
	        						 video.getReleaseDate(),
	        						 video.getId());
	    } else {
	        // insert
	        String sql = "INSERT INTO video (name,genreid,minutes,actors,releasedate) VALUES (?,?,?,?,?)";
	        jdbcTemplate.update(sql, video.getName(),video.getGenreId(),
	        						 video.getMinutes(),video.getActors(),video.getReleaseDate());
	    }
	 

	}

	@Override
	public void delete(int videoId) {
		String sql = "DELETE FROM video WHERE id=?";
		jdbcTemplate.update(sql, videoId);

	}

	@Override
	public Video get(int videoId) {
		/*Java 8 construct*/
		String sql = "SELECT * FROM video WHERE id= " + videoId;
		RowMapper<Video> r = (ResultSet rs, int rowNum) -> new Video(rs.getInt("id"),
																	 rs.getString("name"),
																	 rs.getInt("genreid"),
																	 rs.getInt("minutes"),
																	 rs.getString("actors"),
																	 rs.getDate("releasedate"));
		
		List<Video> listVideo = jdbcTemplate.query(sql, r);
		
		return listVideo.get(0);
	}

	@Override
	public List<Video> list() {
		
		String sql = "SELECT * FROM video";
		
		RowMapper<Video> r = (ResultSet rs, int rowNum) ->  new Video(rs.getInt("id"),
																rs.getString("name"),
																 rs.getInt("genreid"),
																 rs.getInt("minutes"),
																 rs.getString("actors"),
																 rs.getDate("releasedate"));
														
		List<Video> listVideo = jdbcTemplate.query(sql, r);
				
	    return listVideo;
		
	}
	
	@Override
	public List<SearchObject> searchVideo() {
		
		String sql = "SELECT v.name,vi.serialnumber, g.description, v.actors, v.releasedate FROM video v, videoitem vi , genre g where"
				+ " v.id = vi.videoId and v.genreid = g.id and vi.customerid < 1";
		/*Java 8 construct*/	
		RowMapper<SearchObject> r = (ResultSet rs, int rowNum) ->  new SearchObject(rs.getString("name"),
																				rs.getString("serialnumber"),
																				rs.getString("description"),
																				rs.getString("actors"),
																				rs.getDate("releasedate"));
														
		List<SearchObject> searchList = jdbcTemplate.query(sql, r);
		
	    return searchList;
		
	}
	
	@Override
	public List<Genre> getGenres(){
		
		String sql = "SELECT * FROM GENRE";
		/*Java 8 construct*/
		RowMapper<Genre> r = (ResultSet rs, int rowNum) ->  new Genre(rs.getInt("id"),
																	rs.getString("description"));
																
		List<Genre> listGenre = jdbcTemplate.query(sql, r);
		
	    return listGenre;

	}
	
}
