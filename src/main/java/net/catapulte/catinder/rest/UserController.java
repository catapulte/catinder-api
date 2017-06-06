package net.catapulte.catinder.rest;

import net.catapulte.catinder.model.User;
import net.catapulte.catinder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserRepository repository;

    @Autowired
    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/users/{firebaseId}")
    public ResponseEntity users(@PathVariable String firebaseId) {

       return repository.getByFirebaseId(firebaseId)
                .map( user -> new ResponseEntity(user,HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));

    }

    @PutMapping("/users/{firebaseId}")
    public void edit(@PathVariable String firebaseId, @RequestBody User user) {
        repository.save(user);
    }
}