package co.lynth.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;

import co.lynth.daos.CustomerDao;
import co.lynth.daos.CustomerDaoImpl;
import co.lynth.daos.VideoDao;
import co.lynth.daos.VideoDaoImpl;
import co.lynth.daos.VideoItemDao;
import co.lynth.daos.VideoItemDaoImpl;

@Configuration
@ComponentScan(basePackages="co.lynth")
@EnableWebMvc
public class SGConfig extends WebMvcConfigurerAdapter {
	
	@Bean
    public ViewResolver getViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
     
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
 
    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/da4test");
        dataSource.setUsername("da4");
        dataSource.setPassword("bel124");
         
        return dataSource;
    } 
    
    @Bean
    public CustomerDao getCustomerDAO() {
        return new CustomerDaoImpl(getDataSource());
    }
    
    @Bean
    public VideoDao getVideoDAO() {
        return new VideoDaoImpl(getDataSource());
    }
    
    @Bean
    public VideoItemDao getVideoItemDAO() {
        return new VideoItemDaoImpl(getDataSource());
    }
   
    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {
        super.addViewControllers(registry);

        registry.addViewController("/anonymous.html");

        registry.addViewController("/login.html");
        registry.addViewController("/homepage.html");
        registry.addViewController("/console.html");
    }


}
