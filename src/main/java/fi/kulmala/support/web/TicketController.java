package fi.kulmala.support.web;

import fi.kulmala.support.domain.Ticket;
import fi.kulmala.support.domain.TicketRepository;
import fi.kulmala.support.domain.Status;
import fi.kulmala.support.domain.StatusRepository;
import fi.kulmala.support.domain.Urgency;
import fi.kulmala.support.domain.UrgencyRepository;
import fi.kulmala.support.domain.Branch;
import fi.kulmala.support.domain.BranchRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class TicketController {
	@Autowired
	private TicketRepository repository;
	@Autowired
	private StatusRepository repository2;
	@Autowired
	private UrgencyRepository repository4;
	@Autowired
	private BranchRepository repository5;

	public void getTickets() {
		List<Ticket> tickets = repository.findByTopic("*");
	}

	public void getStatuses() {
		List<Status> statuses = repository2.findByName("*");
	}

	public void getUrgencies() {
		List<Urgency> urgencies = repository4.findByName("*");
	}

	public void getBranches() {
		List<Urgency> branches = repository4.findByName("*");
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@ResponseBody
	@RequestMapping("/")
	public String index() {
		return "Nothing to see here! Head to /support";
	}

	@RequestMapping("/support")
	public String ticketlist(Model model) {
		model.addAttribute("tickets", repository.findAll());
		return "support";
	}

	@RequestMapping("/add")
	public String addTicket(Model model) {
		model.addAttribute("ticket", new Ticket());
		model.addAttribute("statuses", repository2.findAll());
		model.addAttribute("urgencies", repository4.findAll());
		model.addAttribute("branches", repository5.findAll());
		return "addticket";
	}

	@PostMapping(value = "/save")
	public String saveTicket(Ticket ticket) {
		repository.save(ticket);
		return "redirect:support";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteTicket(@PathVariable("id") Long ticketId, Model model) {
		repository.deleteById(ticketId);
		return "redirect:../support";
	}

	@RequestMapping(value = "/edit/{id}")
	public String editTicket(@PathVariable("id") Long ticketId, Model model) {
		model.addAttribute("ticket", repository.findById(ticketId));
		model.addAttribute("statuses", repository2.findAll());
		model.addAttribute("urgencies", repository4.findAll());
		model.addAttribute("branches", repository5.findAll());
		return "editticket";
	}

	@RequestMapping(value = "/ticket", method = RequestMethod.GET)
	public @ResponseBody List<Ticket> ticketListRest() {
		return (List<Ticket>) repository.findAll();
	}

	@RequestMapping(value = "/ticket/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Ticket> findTicketRest(@PathVariable("id") Long ticketid) {
		return repository.findById(ticketid);
	}

}
