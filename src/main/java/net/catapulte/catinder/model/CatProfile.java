package net.catapulte.catinder.model;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CatProfile {

    private String name;
    private URL picture;

    private List patounes = new ArrayList<>();
    private List griffounes = new ArrayList<>();

    public CatProfile() {
    }

    public CatProfile(String name, URL picture) {
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

    public List getPatounes() {
        return patounes;
    }

    public void setPatounes(List patounes) {
        this.patounes = patounes;
    }

    public List getGriffounes() {
        return griffounes;
    }

    public void setGriffounes(List griffounes) {
        this.griffounes = griffounes;
    }
}
