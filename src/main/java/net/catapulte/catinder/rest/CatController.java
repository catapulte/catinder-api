package net.catapulte.catinder.rest;

import net.catapulte.catinder.dto.CatinderBean;
import net.catapulte.catinder.model.CatProfile;
import net.catapulte.catinder.model.Catinder;
import net.catapulte.catinder.repository.CatRepository;
import net.catapulte.catinder.repository.CatinderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// FIXME virer mongo :D
@RestController
public class CatController {

    private final CatRepository repository;
    private final CatinderRepository catinderRepository;

    @Autowired
    public CatController(CatRepository repository,CatinderRepository catinderRepository) {
        this.repository = repository;
        this.catinderRepository = catinderRepository;
    }


    @GetMapping("/users/{userId}/cats")
    public List<CatProfile> cats(@PathVariable  String userId) {
        return repository.getByUserId(userId);
    }

    @GetMapping("/cats")
    public List<CatProfile> cats() {
        return repository.findAll();
    }

    @GetMapping("/cats/{id}")
    public ResponseEntity cat(@PathVariable String id) {
        return repository.getById(id)
                .map( cat -> new ResponseEntity(cat,HttpStatus.OK) )
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/cats/{id}")
    public void edit(@PathVariable String id, @RequestBody CatProfile updates) {
        CatProfile p = repository.getById(id).map(
                cat -> {
                    cat.setUserId(updates.getUserId());
                    cat.setName(updates.getName());
                    return cat;
                }
        ).orElse(updates);
        repository.save(p);
    }

    @GetMapping("/cats/{catId}/candidates")
    public List<CatinderBean> candidates(@PathVariable String catId) {
        return catinderRepository.findCandidateForMyCat(catId)
                .parallelStream()
                .map(catinder -> {
                    Optional<CatProfile> myCat = repository.getById(catinder.getId().getMyCatId());
                    Optional<CatProfile> otherCat = repository.getById(catinder.getId().getOtherCatId());
                    return new CatinderBean(myCat.get(),otherCat.get(),catinder.getStatus());
                })
                .collect(Collectors.toList());
    }

    @GetMapping("/cats/{catId}/all")
    public List<CatinderBean> all(@PathVariable String catId) {
        return catinderRepository.findByMyCatId(catId)
                .parallelStream()
                .map(catinder -> {
                    Optional<CatProfile> myCat = repository.getById(catinder.getId().getMyCatId());
                    Optional<CatProfile> otherCat = repository.getById(catinder.getId().getOtherCatId());
                    return new CatinderBean(myCat.get(),otherCat.get(),catinder.getStatus());
                })
                .collect(Collectors.toList());
    }

    @PostMapping("/cats/{catId}/patoune/{otherCatId}")
    public void patoune(@PathVariable String catId, @PathVariable String otherCatId) {
        Catinder catinder = new Catinder(catId, otherCatId, Catinder.Status.PATOUNE);
        catinderRepository.save(catinder);
    }

    @PostMapping("/cats/{catId}/griffoune/{otherCatId}")
    public void griffoune(@PathVariable String catId, @PathVariable String otherCatId) {
        Catinder catinder = new Catinder(catId, otherCatId, Catinder.Status.GRIFFOUNE);
        catinderRepository.save(catinder);
    }

}