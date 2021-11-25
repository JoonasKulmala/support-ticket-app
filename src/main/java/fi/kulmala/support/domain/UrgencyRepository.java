package fi.kulmala.support.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UrgencyRepository extends CrudRepository<Urgency, Long> {
    List<Urgency> findByName(String name);
}