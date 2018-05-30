package guru.cooperhanke.springbootjournal;

import guru.cooperhanke.springbootjournal.entities.Journal;
import guru.cooperhanke.springbootjournal.repos.JournalRepo;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import java.io.PrintStream;

@SpringBootApplication
public class SpringBootJournalApplication {

	@Bean
	InitializingBean saveData(JournalRepo repo) {
		return () -> {
			repo.save(new Journal("Get to know Spring Boot", "01/01/2016", "Today I will learn more Spring Boot!"));
			repo.save(new Journal("Simple Spring Boot Project", "01/02/2016", "I will do my next Spring Boot project"));
			repo.save(new Journal("Spring Boot Reading", "02/01/2016", "Read more about Spring Boot"));
			repo.save(new Journal("Spring Boot in the Cloud", "03/01/2016", "Spring Boot using Cloud Foundry"));
		};
	}

	public static void main(String[] args) {

		SpringApplication app = new SpringApplication(SpringBootJournalApplication.class);
		app.setBanner(new Banner() {
			@Override
			public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
				out.print("\n\nThis is my own banner!!\n\n".toUpperCase());
			}
		});
			app.run(args);
//		SpringApplication.run(SpringBootJournalApplication.class, args);
	}
}