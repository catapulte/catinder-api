package net.catapulte.catinder.model;

import java.net.URL;

public class CatCandidate {

    private String name;
    private URL picture;

    public CatCandidate(String name, URL picture) {
        this.name = name;
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public URL getPicture() {
        return picture;
    }

    public void setPicture(URL picture) {
        this.picture = picture;
    }
}
