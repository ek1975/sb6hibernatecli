package test.aj.sb6.hibernatecrud.dao;

import test.aj.sb6.hibernatecrud.entity.Student;

public interface StudentDAO {
    void save(Student student);
    Student getStudentbyId(int studentId);
}
