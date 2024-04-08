package hh.sof3.traillog.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface RatingRepository extends CrudRepository<Rating, Long> {
    
    List<Rating> findByStarRating(Integer starRating);

}
