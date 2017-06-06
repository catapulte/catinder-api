package net.catapulte.catinder.repository;

import net.catapulte.catinder.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> getByFirebaseId(String firebaseId);
}
