package net.catapulte.catinder.rest;

import net.catapulte.catinder.model.CatCandidate;
import net.catapulte.catinder.model.CatProfile;
import net.catapulte.catinder.repository.MongoCatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CatController {

    private final MongoCatRepository repository;

    @Autowired
    public CatController(MongoCatRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/cats/{name}")
    public CatProfile cats(@PathVariable String name) {
        return repository.getByNameIgnoreCase(name);
    }

    @PutMapping("/cats/{name}")
    public void edit(@PathVariable String name, @RequestBody CatProfile updates) {
        CatProfile p = repository.getByNameIgnoreCase(name);
        updates.getPatounes().forEach(patoune -> p.patoune(patoune));
        updates.getGriffounes().forEach(griffoune -> p.patoune(griffoune));
        repository.save(p);
    }

    @GetMapping("/cats/{name}/candidates")
    public List<CatCandidate> candidates(@PathVariable String name) {
        return repository.getByNameIgnoreCase(name)
                .getCandidates().parallelStream()
                .map(candidateName -> repository.getByNameIgnoreCase(candidateName))
                .map(candidateProfile -> new CatCandidate(candidateProfile.getName(), candidateProfile.getPicture()))
                .collect(Collectors.toList());
    }

    @GetMapping("/cats/{name}/candidates/first")
    public CatCandidate nextCandidate(@PathVariable String name) {
        List<CatCandidate> candidates = candidates(name);
        if (candidates.isEmpty()) {
            return null;
        }
        return candidates.get(0);
    }
}