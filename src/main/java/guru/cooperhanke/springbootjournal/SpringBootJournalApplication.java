package guru.cooperhanke.springbootjournal;

import guru.cooperhanke.springbootjournal.entities.Journal;
import guru.cooperhanke.springbootjournal.repos.JournalRepo;
import guru.cooperhanke.springbootjournal.services.JournalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import java.io.PrintStream;

@SpringBootApplication
public class SpringBootJournalApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringBootJournalApplication.class);

	public static void main(String[] args) {

		SpringApplication app = new SpringApplication(SpringBootJournalApplication.class);
//		app.setBanner(new Banner() {
//			@Override
//			public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
//				out.print("\n\nThis is my own banner!!\n\n".toUpperCase());
//			}
//		});
			app.run(args);
//		SpringApplication.run(SpringBootJournalApplication.class, args);
	}

	@Bean
	CommandLineRunner start(JournalService service) {
		return args -> {
			log.info("@@ Inserting data...");
			service.insertData();
			log.info("@@ findAll() call...");
			service.findAll().forEach(entry -> log.info(entry.toString()));
		};
	}
}