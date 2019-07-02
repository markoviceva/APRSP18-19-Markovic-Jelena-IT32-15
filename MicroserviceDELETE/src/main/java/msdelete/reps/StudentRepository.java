package msdelete.reps;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import msdelete.jpa.Departman;
import msdelete.jpa.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	Collection<Student> findByDepartmanBean(Departman d);
}
