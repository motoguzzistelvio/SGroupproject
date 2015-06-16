package co.lynth.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import co.lynth.daos.VideoDao;
import co.lynth.models.Genre;
import co.lynth.models.SearchObject;
import co.lynth.models.Video;

@Controller
public class VideoController {
	
	@Autowired
	@Qualifier("getVideoDAO")
    private VideoDao videoDao;
	
	@RequestMapping(value="/listVideos")
	public ModelAndView listVideo(ModelAndView model) throws IOException{
	    List<Video> listVideo = videoDao.list();
	    model.addObject("listvideo", listVideo);
	    model.setViewName("video");
	 
	    return model;
	}
	
	@RequestMapping(value = "/newVideo", method = RequestMethod.GET)
	public ModelAndView newVideo(ModelAndView model) {
	    Video newVideo = new Video();
	    model.addObject("video", newVideo);
	    model.addObject("genres", videoDao.getGenres());
	    model.setViewName("videoForm");
	   
	    return model;
	}
	
	@RequestMapping(value = "/saveVideo", method = RequestMethod.POST)
	public ModelAndView saveVideo(@ModelAttribute Video video) {
		videoDao.saveOrUpdate(video);
	    return new ModelAndView("redirect:/listVideos");
	}
	
	@RequestMapping(value = "/deleteVideo", method = RequestMethod.GET)
	public ModelAndView deleteVideo(HttpServletRequest request) {
	    int videoId = Integer.parseInt(request.getParameter("id"));
	    videoDao.delete(videoId);
	    return new ModelAndView("redirect:/listVideos");
	}
	
	@RequestMapping(value = "/editVideo", method = RequestMethod.GET)
	public ModelAndView editVideo(HttpServletRequest request) {
		int videoId = Integer.parseInt(request.getParameter("id"));
		Video video = videoDao.get(videoId);
		ModelAndView model = new ModelAndView("videoForm","video",video);
	    model.addObject("genres", videoDao.getGenres());
	
		return model;
	}
	@RequestMapping(value="/searchVideo")
	public ModelAndView serachVideo(ModelAndView model) throws IOException{
	    List<SearchObject> listObject = videoDao.searchVideo();
	    model.addObject("listSearch", listObject);
	    SearchObject searchObject = new SearchObject();
	    model.addObject("searchobject", searchObject);
	    model.setViewName("availVidSearch");
	 
	    return model;
	}

}
