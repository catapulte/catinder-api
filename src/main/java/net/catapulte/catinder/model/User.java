package net.catapulte.catinder.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by erwann on 23/05/17.
 */
@Data
@Document(collection = "user")
public class User {

    @Id
    private String firebaseId;

}
