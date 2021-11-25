package fi.kulmala.support.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
	List<Ticket> findByTopic(String topic);

}