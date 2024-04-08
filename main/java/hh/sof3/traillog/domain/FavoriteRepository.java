package hh.sof3.traillog.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//hallinnollinen @Repository-annotaatio komponentteja varten
@Repository
public interface FavoriteRepository extends CrudRepository<Favorite, Long>{
    List<Favorite> findByUserId(Long userid);
}
