package net.catapulte.catinder.repository;

import net.catapulte.catinder.model.Catinder;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CatinderRepository extends MongoRepository<Catinder, Catinder.CatinderKey> {

    @Query("{ '_id.myCatId' : ?0 }")
    List<Catinder> findByMyCatId(String catId);

    @Query("{ '_id.myCatId' : ?0, 'status': null  }")
    List<Catinder> findCandidateForMyCat(String catID);

}
