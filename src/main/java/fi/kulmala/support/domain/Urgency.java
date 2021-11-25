package fi.kulmala.support.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Urgency {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long urgencyid;
    private String name;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "urgency")
    private List<Ticket> tickets;

    public Urgency() {

    }

    public Urgency(String name) {
        super();
        this.name = name;
    }

    public Long getUrgencyid() {
        return urgencyid;
    }

    public void setUrgencyid(Long urgencyid) {
        this.urgencyid = urgencyid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        return "Urgency [urgencyid=" + urgencyid + ", name=" + name + "]";
    }

}