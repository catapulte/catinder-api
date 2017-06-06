package net.catapulte.catinder.rest;

import net.catapulte.catinder.model.CatData;
import net.catapulte.catinder.model.Catinder;
import net.catapulte.catinder.repository.CatDataRepository;
import net.catapulte.catinder.repository.CatinderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by erwann on 05/06/17.
 */
@RestController
public class TestController {

    @Autowired
    private CatDataRepository catDataRepository;

    @Autowired
    private CatinderRepository catinderRepository;

    @GetMapping("/test")
    public void test() {
        CatData catData = new CatData();
        catData.setPosition(new double[]{48.302631, -1.666984});
        catData.setId("1");
        catData.setTimestamp(new Date().getTime());
        catDataRepository.save(catData);

        catData = new CatData();
        catData.setPosition(new double[]{48.302329, -1.665550});
        catData.setId("2");
        catData.setTimestamp(new Date().getTime());
        catDataRepository.save(catData);

        catData = new CatData();
        catData.setPosition(new double[]{48.303597, -1.666191});
        catData.setId("3");
        catData.setTimestamp(new Date().getTime());
        catDataRepository.save(catData);

        catData = new CatData();
        catData.setPosition(new double[]{48.304469, -1.664748});
        catData.setId("4");
        catData.setTimestamp(new Date().getTime());
        catDataRepository.save(catData);

        catData = new CatData();
        catData.setPosition(new double[]{48.303554, -1.665512});
        catData.setId("5");
        catData.setTimestamp(new Date().getTime());
        catDataRepository.save(catData);

        Catinder catinder = new Catinder("1","2", Catinder.Status.PATOUNE);
        catinderRepository.save(catinder);

        catinder = new Catinder("1","3");
        catinderRepository.save(catinder);

        catinder = new Catinder("1","4");
        catinderRepository.save(catinder);
    }
}
