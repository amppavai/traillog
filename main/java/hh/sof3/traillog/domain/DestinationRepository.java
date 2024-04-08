package hh.sof3.traillog.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface DestinationRepository extends CrudRepository<Destination, Long>{

    List<Destination> findByDestName(String destName);

}
