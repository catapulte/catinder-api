package net.catapulte.catinder.repository;

import net.catapulte.catinder.model.CatProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MongoCatRepository extends MongoRepository<CatProfile, String> {

    CatProfile getByNameIgnoreCase(String name);

    List<CatProfile> findByCandidates(String patounes);
}
