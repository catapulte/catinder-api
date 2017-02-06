package net.catapulte.catinder.model;

import lombok.Data;

import java.net.URL;

@Data
public class CatCandidate {

    private String name;
    private URL picture;

    public CatCandidate(String name, URL picture) {
        this.name = name;
        this.picture = picture;
    }
}
