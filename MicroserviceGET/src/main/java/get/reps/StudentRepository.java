package get.reps;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import get.jpa.Departman;
import get.jpa.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	Collection<Student> findByDepartmanBean(Departman d);
}
