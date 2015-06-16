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

import co.lynth.models.Customer;


@Transactional
@Component
public class CustomerDaoImpl implements CustomerDao {


	private JdbcTemplate jdbcTemplate;
		
	public CustomerDaoImpl(DataSource dataSource){
			
		jdbcTemplate = new JdbcTemplate(dataSource);
			
	}
	
	public CustomerDaoImpl(){
					
	}
	
	@Override
	public void saveOrUpdate(Customer customer) {
		if (customer.getId() > 0) {
	        // update
	        String sql = "UPDATE customer SET firstname=? ,surname=?, idnumber=? WHERE id=?";
	        jdbcTemplate.update(sql, customer.getFirstname(),customer.getSurname(),
	        		customer.getIdnumber(), customer.getId());
	    } else {
	        // insert
	        String sql = "INSERT INTO customer (firstname,surname,idnumber) VALUES (?,?,?)";
	        jdbcTemplate.update(sql, customer.getFirstname(),customer.getSurname(),
	        		customer.getIdnumber());
	    }

	}

	@Override
	public void delete(int customerId) {
		String sql = "DELETE FROM customer WHERE id=?";
		jdbcTemplate.update(sql, customerId);

	}

	@Override
	public Customer get(int customerId) {
			
		String sql = "SELECT * FROM customer WHERE id= " + customerId;
		RowMapper<Customer> r = (ResultSet rs, int rowNum) -> new Customer(rs.getInt("id"),
					rs.getString("firstname"),
					rs.getString("surname"),
					rs.getString("idnumber"),
					rs.getTimestamp("CreateDate"));
		
		List<Customer> listCustomer = jdbcTemplate.query(sql, r);
			
		return listCustomer.get(0);
	}

	@Override
	public List<Customer> list() {
		String sql = "SELECT * FROM customer";
				
		RowMapper<Customer> r = (ResultSet rs, int rowNum) -> new Customer(rs.getInt("id"),
																rs.getString("firstname"),
																rs.getString("surname"),
																rs.getString("idnumber"),
																rs.getTimestamp("CreateDate"));
			
		List<Customer> listCustomer = jdbcTemplate.query(sql, r);
			
	    return listCustomer;
			
	}

}
