package net.catapulte.catinder.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Created by erwann on 05/06/17.
 */
@Data
@Document(collection = "catinder")
public class Catinder {

    @Id
    private CatinderKey id;

    private Status status;

    public Catinder() {
    }

    public Catinder(String myCatId, String otherCatId) {
        id = new CatinderKey(myCatId, otherCatId);
    }

    public Catinder(String myCatId, String otherCatId, Status status) {
        id = new CatinderKey(myCatId, otherCatId);
        this.status = status;
    }

    public static class CatinderKey implements Serializable {

        private String myCatId;
        private String otherCatId;

        public CatinderKey(String myCatId, String otherCatId) {
            this.myCatId = myCatId;
            this.otherCatId = otherCatId;
        }

        public String getMyCatId() {
            return myCatId;
        }

        public String getOtherCatId() {
            return otherCatId;
        }
    }

    public  enum Status{
        PATOUNE,
        GRIFFOUNE
    }
}
