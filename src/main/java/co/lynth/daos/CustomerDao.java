package co.lynth.daos;

import java.util.List;

import org.springframework.stereotype.Component;

import co.lynth.models.Customer;
@Component
public interface CustomerDao {
	
 public void saveOrUpdate(Customer customer);
     
 public void delete(int customerId);
	     
 public Customer get(int customerId);
	     
 public List<Customer> list();


}
