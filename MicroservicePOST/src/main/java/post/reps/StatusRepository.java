package post.reps;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import post.jpa.Status;

public interface StatusRepository extends JpaRepository<Status, Integer> {
	Collection<Status> findByNazivContainingIgnoreCase(String naziv);
}
