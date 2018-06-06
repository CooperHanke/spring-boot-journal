package guru.cooperhanke.springbootjournal.services;

import guru.cooperhanke.springbootjournal.entities.Journal;
import guru.cooperhanke.springbootjournal.repos.JournalRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public class JournalService {
    private static final Logger log = LoggerFactory.getLogger(JournalService.class);

    @Autowired
    JournalRepo repo;

    public void insertData() throws ParseException {
        log.info("> Inserting data...");
        repo.save(new Journal("Get to know Spring Boot", "01/01/2016", "Today I will learn more Spring Boot!"));
        repo.save(new Journal("Simple Spring Boot Project", "01/02/2016", "I will do my next Spring Boot project"));
        repo.save(new Journal("Spring Boot Reading", "02/01/2016", "Read more about Spring Boot"));
        repo.save(new Journal("Spring Boot in the Cloud", "03/01/2016", "Spring Boot using Cloud Foundry"));
        log.info("> Done.");
    }

    public List<Journal> findAll() {
        return repo.findAll();
    }
}
