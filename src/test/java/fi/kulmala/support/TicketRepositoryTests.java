package fi.kulmala.support;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import fi.kulmala.support.domain.Ticket;
import fi.kulmala.support.domain.TicketRepository;
import fi.kulmala.support.domain.Status;
import fi.kulmala.support.domain.StatusRepository;
import fi.kulmala.support.domain.User;
import fi.kulmala.support.domain.UserRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class TicketRepositoryTests {

	@Autowired
	private TicketRepository ticketrepository;
	@Autowired
	private StatusRepository statusrepository;
	@Autowired
	private UserRepository userrepository;

	// Find Book by title attribute
	@Test
	public void findByTitleShouldReturnBook() {
		List<Ticket> tickets = ticketrepository.findByTopic("Example Title");

		assertThat(tickets).hasSize(1);
		assertThat(tickets.get(0).getTopic()).isEqualTo("Example Title");
	}

	// Create new Category
	@Test
	public void createCategory() {
		Status status = new Status("Biology");
		statusrepository.save(status);
		assertThat(status.getStatusid()).isNotNull();
	}

	// Delete existing Book
	@Test
	public void deleteTicket() {
		List<Ticket> tickets = ticketrepository.findByTopic("Example Title");
		Ticket ticket = tickets.get(0);
		ticketrepository.delete(ticket);
		List<Ticket> newTickets = ticketrepository.findByTopic("Example title");
		assertThat(newTickets).hasSize(0);

	}

}