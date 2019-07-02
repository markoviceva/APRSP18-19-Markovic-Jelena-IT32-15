package post.reps;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import post.jpa.Fakultet;

public interface FakultetRepository extends JpaRepository<Fakultet, Integer> {
	Collection<Fakultet> findByNazivContainingIgnoreCase(String naziv);
}
