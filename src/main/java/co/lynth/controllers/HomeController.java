package co.lynth.controllers;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import co.lynth.models.Video;
 
@Controller
public class HomeController {
 
	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {
 
		ModelAndView model = new ModelAndView();
		Video newVideo = new Video();
		model.addObject("title", "SG Video Store");
		model.addObject("message", "Welcome!");
		model.addObject("video",newVideo);
		model.setViewName("homepage");
		return model;
 
	}
 
	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {
 
		ModelAndView model = new ModelAndView();
		model.addObject("title", "SG Video Store");
		model.addObject("message", "Login to access system functions!");
		model.setViewName("login");
 
		return model;
 
	}
 
	@RequestMapping(value = "/dba**", method = RequestMethod.GET)
	public ModelAndView dbaPage() {
 
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is protected page - Database Page!");
		model.setViewName("admin");
 
		return model;
 
	}
	@RequestMapping(value = "/maintMenu**", method = RequestMethod.GET)
	public ModelAndView maiMenu() {
 
		ModelAndView model = new ModelAndView();
		model.addObject("title", "SG Video Store");
		model.addObject("message", "Click on a menu item");
		model.setViewName("maintMenu");
 
		return model;
 
	}

 
}