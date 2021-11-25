package fi.kulmala.support;

import fi.kulmala.support.domain.*;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PalvelinohjelmointiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PalvelinohjelmointiApplication.class, args);
	}

	@Bean
	public CommandLineRunner productionDemo(TicketRepository repository, StatusRepository repository2,
			UserRepository repository3, UrgencyRepository repository4, BranchRepository repository5) {
		return (args) -> {

			// Clear database on startup
			repository.deleteAll();
			repository2.deleteAll();
			repository3.deleteAll();
			repository4.deleteAll();

			// Hard coded Objects for demo purposes

			// Login credentials = user/user, admin/admin
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			repository3.save(user1);
			repository3.save(user2);

			repository2.save(new Status("Open"));
			repository2.save(new Status("Working On"));
			repository2.save(new Status("Closed"));

			repository4.save(new Urgency("Low"));
			repository4.save(new Urgency("High"));
			repository4.save(new Urgency("Critical"));

			repository5.save(new Branch("Legal"));
			repository5.save(new Branch("Sales & Rep"));
			repository5.save(new Branch("Management"));
			repository5.save(new Branch("IT"));

			// repository.save(new Ticket("Printer jammed", "Sales & Rep", "Mathew Market",
			// repository4.findByName("Low").get(0),
			// repository2.findByName("Open").get(0)));

			repository.save(new Ticket("Laptop on fire", "Larry Lawyer", repository5.findByName("Legal").get(0),
					repository4.findByName("High").get(0), repository2.findByName("Working On").get(0)));

		};
	}

}