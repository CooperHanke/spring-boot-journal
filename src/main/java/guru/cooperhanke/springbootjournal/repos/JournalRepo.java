package guru.cooperhanke.springbootjournal.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import guru.cooperhanke.springbootjournal.entities.Journal;

public interface JournalRepo extends JpaRepository<Journal, Long>{}
