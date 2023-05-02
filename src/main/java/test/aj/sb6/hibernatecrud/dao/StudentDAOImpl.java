package test.aj.sb6.hibernatecrud.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import test.aj.sb6.hibernatecrud.entity.Student;

import java.util.List;

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

    @Override
    public List<Student> getMatchingStudents() {
//        TypedQuery<Student> q1 = entityManager.createQuery("FROM Student", Student.class); firstName = :v1 or
        TypedQuery<Student> q1 = entityManager.createQuery("FROM Student where firstName like :v1 or lastName = 'B' order by lastName desc", Student.class);
        q1.setParameter("v1", "A%");
        return q1.getResultList();
    }
}
