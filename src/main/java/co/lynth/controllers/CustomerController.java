package co.lynth.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import co.lynth.daos.CustomerDao;
import co.lynth.models.Customer;

@Controller
public class CustomerController {
	
	@Autowired
	@Qualifier("getCustomerDAO")
    private CustomerDao customerDao;
	
	@RequestMapping(value="/listCustomers")
	public ModelAndView listCustomer(ModelAndView model) throws IOException{
	    List<Customer> listCustomer = customerDao.list();
	    model.addObject("listcustomer", listCustomer);
	    model.setViewName("customer");
	 
	    return model;
	}
	
	@RequestMapping(value = "/newCustomer", method = RequestMethod.GET)
	public ModelAndView newCustomer(ModelAndView model) {
		Customer newCustomer = new Customer();
	    model.addObject("customer", newCustomer);
	    model.setViewName("customerForm");
	    
	    return model;
	}
	
	@RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
	public ModelAndView saveCustomer(@ModelAttribute Customer customer) {
		customerDao.saveOrUpdate(customer);
		
	    return new ModelAndView("redirect:/listCustomers");
	}
	
	@RequestMapping(value = "/deleteCustomer", method = RequestMethod.GET)
	public ModelAndView deleteCustomer(HttpServletRequest request) {
	    int customerId = Integer.parseInt(request.getParameter("id"));
	    customerDao.delete(customerId);
	    
	    return new ModelAndView("redirect:/listCustomers");
	}
	
	@RequestMapping(value = "/editCustomer", method = RequestMethod.GET)
	public ModelAndView editCustomer(HttpServletRequest request) {
		int customerId = Integer.parseInt(request.getParameter("id"));
		Customer customer = customerDao.get(customerId);
		ModelAndView model = new ModelAndView("customerForm");
		model.addObject("customer", customer);
		
		return model;
	}
}
