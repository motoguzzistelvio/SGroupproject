package co.lynth.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import co.lynth.daos.CustomerDao;
import co.lynth.daos.VideoDao;
import co.lynth.daos.VideoItemDao;
import co.lynth.models.Customer;
import co.lynth.models.Video;
import co.lynth.models.VideoItem;

@Controller
public class VideoItemController {
	
	@Autowired
	@Qualifier("getVideoItemDAO")
    private VideoItemDao videoItemDao;
	
	@Autowired
	@Qualifier("getVideoDAO")
    private VideoDao videoDao;
	
	@Autowired
	@Qualifier("getCustomerDAO")
    private CustomerDao customerDao;
	
	@RequestMapping(value="/listVideoItems")
	public ModelAndView listVideo(ModelAndView model) throws IOException{
	    List<VideoItem> listVideoItem = videoItemDao.list();
	    model.addObject("listVideoItems", listVideoItem);
	    model.setViewName("videoItem");
	 
	    return model;
	}
	
	@RequestMapping(value = "/newVideoItem", method = RequestMethod.GET)
	public ModelAndView newVideo(ModelAndView model) {
	    VideoItem newVideoItem = new VideoItem();
	    List<Customer> listCustomer = customerDao.list();
	    model.addObject("listcustomer", listCustomer);
	    
	    List<Video> listVideo = videoDao.list();
	    model.addObject("listvideo", listVideo);
	    
	    model.addObject("videoitem", newVideoItem);
	    model.setViewName("videoItemForm");
	    
	    return model;
	}
	
	@RequestMapping(value = "/saveVideoItem", method = RequestMethod.POST)
	public ModelAndView saveVideo(@ModelAttribute VideoItem videoItem) {
		videoItemDao.saveOrUpdate(videoItem);
	    return new ModelAndView("redirect:/listVideoItems");
	}
	
	@RequestMapping(value = "/deleteVideoItem", method = RequestMethod.GET)
	public ModelAndView deleteVideo(HttpServletRequest request) {
	    int videoItemId = Integer.parseInt(request.getParameter("id"));
	    videoItemDao.delete(videoItemId);
	    return new ModelAndView("redirect:/listVideoItems");
	}
	
	@RequestMapping(value = "/editVideoItem", method = RequestMethod.GET)
	public ModelAndView editVideoItem(HttpServletRequest request) {
		int videoItemId = Integer.parseInt(request.getParameter("id"));
		VideoItem videoItem = videoItemDao.get(videoItemId);
		ModelAndView model = new ModelAndView("videoItemForm","videoitem",videoItem);
		
	    List<Customer> listCustomer = customerDao.list();
	    model.addObject("listcustomer", listCustomer);
	    
	    List<Video> listVideo = videoDao.list();
	    model.addObject("listvideo", listVideo);
	
		return model;
	}
}
