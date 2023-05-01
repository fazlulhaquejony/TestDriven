package com.fjtechsolutions.testDrivenMvc;

import com.fjtechsolutions.testDrivenMvc.dao.ApplicationDao;
import com.fjtechsolutions.testDrivenMvc.models.CollegeStudent;
import com.fjtechsolutions.testDrivenMvc.services.ApplicationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class TestDrivenMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestDrivenMvcApplication.class, args);
	}


	/* New for Section 2.2 */
	@Bean(name = "applicationExample")
	ApplicationService getApplicationService() {
		return new ApplicationService();
	}

	/* New for Section 2.2 */
	@Bean(name = "applicationDao")
	ApplicationDao getApplicationDao() {
		return new ApplicationDao();
	}

	@Bean(name = "collegeStudent")
	@Scope(value = "prototype")
	CollegeStudent getCollegeStudent() {
		return new CollegeStudent();
	}

}
