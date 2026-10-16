package in.strikes.crudProjectDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication
public class CrudProjectDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudProjectDemoApplication.class, args);


	}

}
