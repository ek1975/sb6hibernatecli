package test.aj.sb6.hibernatecrud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import test.aj.sb6.hibernatecrud.dao.StudentDAO;
import test.aj.sb6.hibernatecrud.entity.Student;

import java.util.List;
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
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);
//			findByStudentId(studentDAO, 2);
//			findAllMatchingStudents(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
//			deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Total students deleted: " + studentDAO.deleteAllStudents());
	}

	private void deleteStudent(StudentDAO studentDAO) {
		studentDAO.deleteStudentById(2);
	}

	private void updateStudent(StudentDAO studentDAO) {
		Student student = studentDAO.getStudentbyId(1);
		student.setFirstName("C");
		studentDAO.updateStudent(student);
	}

	private void findAllMatchingStudents(StudentDAO studentDAO) {
		List<Student> l1 = studentDAO.getMatchingStudents();
		for (Student s1: l1) {
			System.out.println(s1);
		}
	}

	private void findByStudentId(StudentDAO studentDAO, int studentId) {
		System.out.println("Getting student whose id is " + studentId);
		Student student = studentDAO.getStudentbyId(studentId);
		System.out.println("Student info: " + student);
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating student...");
		Student student = new Student("A", "A", "a@a.a");
		studentDAO.save(student);
		System.out.println("ID of student just created is: " + student.getId());
		student = new Student("B", "B", "b@b.b");
		studentDAO.save(student);
		System.out.println("ID of student just created is: " + student.getId());
	}
}
