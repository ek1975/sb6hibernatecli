package test.aj.sb6.hibernatecrud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
/*
Hibernate CLI CRUD Project Sequence: Part A:
1) Open MySQL workbench, connect to Local instance u/ root/root.  Open & execute 01-create-user.sql to create
springstudent/springstudent.  Check created user using Navigator > Users and Privileges.
2) Close the current tabs and hit + to create a new connection (springstudent) & 'Test connection’ using
springstudent/springstudent.
3) Connect to new connection & run 02-student-tracker.sql.  Refresh the schemas tab to see the new database
student_tracker and the student table.
4) Open the project and add the following to the main app
@Bean //CommandLineRunner is from SB framework, executes after beans are loaded
public CommandLineRunner commandLineRunner(String[] args) {return runner -> {System.out.println("Hi!");};}
5) Add the following to app.prop and run
spring.datasource.url=jdbc:mysql://localhost:3306/student_tracker
spring.datasource.username=springstudent
spring.datasource.password=springstudent
6) To turn off SB banner, add spring.main.banner-mode=off in app.prop
7) To set the logging level to warn, add logging.level.root=warn
*/

@SpringBootApplication
public class HibernatecrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernatecrudApplication.class, args);
	}

	//CommandLineRunner is from SB framework, executes after beans are loaded
	@Bean
	public CommandLineRunner commandLineRunner(String[] args) {
		return runner -> {
			System.out.println("Hi Andrew! Let's try to run Hibernate through CLI!");
		};
	}
}
