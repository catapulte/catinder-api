package net.catapulte.catinder.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.net.URL;
import java.util.HashSet;
import java.util.Set;

@Data
@Document(collection = "cat")
public class CatProfile {

    @Id
    private String id;
    private String name;
    private String userId;

    public CatProfile() {
    }

    public CatProfile(String id, String name, String userId) {
        this.id = id;
        this.name = name;
        this.userId = userId;
    }
}
