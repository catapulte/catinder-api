package net.catapulte.catinder.rest;

import net.catapulte.catinder.model.CatData;
import net.catapulte.catinder.repository.CatDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class CatDataController {

    @Autowired
    private CatDataRepository catRepository;

    @GetMapping("/catdata")
    public List<CatData> getAllCat(@RequestParam double lat, @RequestParam double lng, @RequestParam long distance) {

        Point point = new Point(lat, lng);
        Distance distance1 = new Distance(distance, Metrics.KILOMETERS);

        Circle circle = new Circle(point, distance1);

        return catRepository.findByPositionWithin(circle);
    }

    @GetMapping("/catdata/{id}")
    public CatData getCat(@PathVariable String id) {
        return catRepository.findOne(id);
    }

    @PostMapping
    public void postCat(@RequestBody CatData cat) {
        catRepository.save(cat);
    }

}
