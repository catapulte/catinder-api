package net.catapulte.catinder.rest;

import net.catapulte.catinder.model.CatProfile;
import net.catapulte.catinder.repository.MongoCatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@RestController
public class MockDataController {

    private final MongoCatRepository repository;

    @Autowired
    public MockDataController(MongoCatRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/data")
    public void resetData() throws MalformedURLException {
        repository.deleteAll();
        cat("Malibu", "http://www.spa-du-dauphine.fr/administration/images/Malibu_opt.jpg");
        cat("Bijou", "http://www.spa-du-dauphine.fr/administration/images/14441196_667357176753663_7281245201346793835_n.jpg");
        cat("Pepette", "http://www.spa-du-dauphine.fr/administration/images/pepppete.jpg");
        cat("Mini", "http://www.spa-du-dauphine.fr/administration/images/15781527_720867868069260_7171236437465522994_n.jpg");
        cat("Nala", "http://www.spa-du-dauphine.fr/administration/images/nala_1.JPG");
        cat("Lumi", "http://www.spa-du-dauphine.fr/administration/images/LUMI.JPG");
        cat("Mike", "http://www.spa-du-dauphine.fr/administration/images/mike.JPG");
        cat("Lola", "http://www.spa-du-dauphine.fr/administration/images/unnamed.jpg");
        cat("Mika", "http://www.spa-du-dauphine.fr/administration/images/milla1.jpg");
        cat("Mickey", "http://www.la-spa.fr/sites/default/files/styles/fiche_animal_620x375/public/animals/276983_2.jpg");
        cat("Savane", "http://www.la-spa.fr/sites/default/files/styles/fiche_animal_620x375/public/animals/308667.jpg");
        cat("Melissa", "http://www.la-spa.fr/sites/default/files/styles/fiche_animal_620x375/public/animals/308836_1.jpg?itok=Up86lWEQ");
        cat("Coucou", "http://www.la-spa.fr/sites/default/files/styles/fiche_animal_620x375/public/animals/308835.jpg?itok=vLwbjLHg");


        List<CatProfile> cats = repository.findAll();
        cats.forEach(cat -> {
            int nbCandidates = (int) (Math.random() * cats.size());
            for (int i = 0; i < nbCandidates; i++) {
                int random = (int) (Math.random() * cats.size());
                CatProfile candidate = cats.get(random);
                if (candidate.getId().equals(cat.getId())) {
                    candidate = cats.get((random + 1) % cats.size());
                }
                cat.getCandidates().add(candidate.getName());
                candidate.getCandidates().add(cat.getName());
            }
        });
        cats.forEach(repository::save);
    }

    private void cat(String name, String picture) throws MalformedURLException {
        repository.save(new CatProfile(name, new URL(picture)));
    }
}
