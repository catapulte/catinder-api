package net.catapulte.catinder.repository;

import net.catapulte.catinder.model.CatData;
import org.springframework.data.geo.Circle;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface CatDataRepository extends MongoRepository<CatData, String> {

    List<CatData> findByPositionWithin(Circle c);
}
