package msdelete.reps;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import msdelete.jpa.Fakultet;

public interface FakultetRepository extends JpaRepository<Fakultet, Integer> {
	Collection<Fakultet> findByNazivContainingIgnoreCase(String naziv);
}
