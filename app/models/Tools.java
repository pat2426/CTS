package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Meaks on 12/4/2015.
 */
@Entity
public class Tools extends Model {

   @Id

    public Long id;
    public String name;
    public String folder;


}
