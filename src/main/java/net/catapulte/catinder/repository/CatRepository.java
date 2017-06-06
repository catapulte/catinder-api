package net.catapulte.catinder.repository;

import net.catapulte.catinder.model.CatProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CatRepository extends MongoRepository<CatProfile, String> {

    Optional<CatProfile> getById(String id);

    List<CatProfile> getByUserId(String userId);

}
