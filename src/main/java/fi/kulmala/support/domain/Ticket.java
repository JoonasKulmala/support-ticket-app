package fi.kulmala.support.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ticketid;
	private String topic;
	private String starter;
	@ManyToOne
	@JoinColumn(name = "urgencyid")
	private Urgency urgency;
	@ManyToOne
	@JoinColumn(name = "branchid")
	private Branch branch;
	@ManyToOne
	@JoinColumn(name = "statusid")
	private Status status;

	public Ticket() {

	}

	public Ticket(String topic, String starter, Branch branch, Urgency urgency, Status status) {
		super();
		this.topic = topic;
		this.starter = starter;
		this.branch = branch;
		this.urgency = urgency;
		this.status = status;
	}

	public Long getId() {
		return ticketid;
	}

	public void setId(Long id) {
		this.ticketid = id;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public String getStarter() {
		return starter;
	}

	public void setStarter(String starter) {
		this.starter = starter;
	}

	public Urgency getUrgency() {
		return urgency;
	}

	public void setUrgency(Urgency urgency) {
		this.urgency = urgency;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		if (this.status != null)
			return "Ticket [ticketid=" + ticketid + ", topic=" + topic + ", starter=" + starter + ", branch="
					+ this.getBranch() + ", urgency=" + urgency + ",status=" + this.getStatus() + ", urgency="
					+ this.getUrgency() + "]";
		else
			return "Ticket [ticketid=" + ticketid + ", topic=" + topic + ", starter=" + starter + "]";
	}

}
