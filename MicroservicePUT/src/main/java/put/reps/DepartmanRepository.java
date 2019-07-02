package put.reps;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import put.jpa.Departman;
import put.jpa.Fakultet;

public interface DepartmanRepository extends JpaRepository<Departman, Integer> {
	Collection<Departman> findByNazivContainingIgnoreCase(String naziv);
	Collection<Departman> findByFakultetBean(Fakultet f);
}
