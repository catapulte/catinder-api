package net.catapulte.catinder.repository;

import net.catapulte.catinder.model.CatCandidate;
import net.catapulte.catinder.model.CatProfile;

import java.util.List;

public interface CatRepository {

    CatProfile get(String name);

    List<CatCandidate> getCandidatesFor(String name);
}
