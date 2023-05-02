package test.aj.sb6.hibernatecrud.dao;

import test.aj.sb6.hibernatecrud.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student getStudentbyId(int studentId);

    List<Student> getMatchingStudents();

    void updateStudent(Student student);

    void deleteStudentById(int studentId);

    int deleteAllStudents();
}
