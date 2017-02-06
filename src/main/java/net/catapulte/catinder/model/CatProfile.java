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
    private URL picture;

    private Set<String> candidates = new HashSet<>();
    private Set<String> patounes = new HashSet<>();
    private Set<String> griffounes = new HashSet<>();

    public CatProfile() {
    }

    public CatProfile(String name, URL picture) {
        this.name = name;
        this.picture = picture;
    }

    public void patoune(String name) {
        candidates.remove(name);
        patounes.add(name);
    }

    public void griffoune(String name) {
        candidates.remove(name);
        griffounes.add(name);
    }
}
