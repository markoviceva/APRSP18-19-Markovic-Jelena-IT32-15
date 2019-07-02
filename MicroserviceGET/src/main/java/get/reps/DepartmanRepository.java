package get.reps;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import get.jpa.Departman;
import get.jpa.Fakultet;

public interface DepartmanRepository extends JpaRepository<Departman, Integer> {
	Collection<Departman> findByNazivContainingIgnoreCase(String naziv);
	Collection<Departman> findByFakultetBean(Fakultet f);
}
