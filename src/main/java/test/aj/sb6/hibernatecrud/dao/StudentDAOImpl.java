package test.aj.sb6.hibernatecrud.dao;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import test.aj.sb6.hibernatecrud.entity.Student;

@Repository //Component scanning, translates JDBC exceptions
public class StudentDAOImpl implements StudentDAO{

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional //from the Spring framework, not jakarta
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student getStudentbyId(int studentId) {
        return entityManager.find(Student.class, studentId);
    }
}
