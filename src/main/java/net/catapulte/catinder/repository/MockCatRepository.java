package net.catapulte.catinder.repository;

import net.catapulte.catinder.model.CatCandidate;
import net.catapulte.catinder.model.CatProfile;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MockCatRepository implements CatRepository {

    private final Map<String, CatProfile> cats = new HashMap<>();

    public MockCatRepository() {
        try {
            cats.put("Malibu", new CatProfile("Malibu", new URL("http://www.spa-du-dauphine.fr/administration/images/Malibu_opt.jpg")));
            cats.put("Bijou", new CatProfile("Bijou", new URL("http://www.spa-du-dauphine.fr/administration/images/14441196_667357176753663_7281245201346793835_n.jpg")));
            cats.put("Pepette", new CatProfile("Pepette", new URL("http://www.spa-du-dauphine.fr/administration/images/pepppete.jpg")));
            cats.put("Mini", new CatProfile("Mini", new URL("http://www.spa-du-dauphine.fr/administration/images/15781527_720867868069260_7171236437465522994_n.jpg")));
        } catch (MalformedURLException e) {
            throw new IllegalStateException(e);
        }
    }

    public CatProfile get(String name) {
        return cats.get(name);
    }

    public List<CatCandidate> getCandidatesFor(String name) {
        CatProfile p = cats.get(name);
        return cats.values().stream()
                .filter(c -> !c.getName().equals(name))
                .filter(c -> !p.getGriffounes().contains(c.getName()))
                .filter(c -> !p.getPatounes().contains(c.getName()))
                .map(c -> new CatCandidate(c.getName(), c.getPicture()))
                .collect(Collectors.toList());
    }
}
