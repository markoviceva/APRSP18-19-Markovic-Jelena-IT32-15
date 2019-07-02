package post.reps;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import post.jpa.Departman;
import post.jpa.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	Collection<Student> findByDepartmanBean(Departman d);
}
