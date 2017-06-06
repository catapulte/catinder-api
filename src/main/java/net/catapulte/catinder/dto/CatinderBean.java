package net.catapulte.catinder.dto;

import lombok.Data;
import net.catapulte.catinder.model.CatProfile;
import net.catapulte.catinder.model.Catinder;

/**
 * Created by erwann on 05/06/17.
 */
@Data
public class CatinderBean {

    private CatProfile myCat;
    private CatProfile otherCat;

    private Catinder.Status status;

    public CatinderBean(CatProfile myCat, CatProfile otherCat, Catinder.Status status) {
        this.myCat = myCat;
        this.otherCat = otherCat;
        this.status = status;
    }
}
