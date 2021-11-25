package fi.kulmala.support.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface BranchRepository extends CrudRepository<Branch, Long> {
    List<Branch> findByName(String name);
}