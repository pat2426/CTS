package models;

import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

/**
 * Created by Meaks on 12/4/2015.
 */
@Entity
public class Tools extends Model {

   @Id
    public Long id;
    @Constraints.Required
    public String name;
    @Constraints.Required
    public String description;
    @Constraints.Required
    public String type;
    @Constraints.Required
    public String section;

public static Finder<Long,Tools> find = new Finder(
    Long.class, Tools.class);

public static List<Tools> all(){
 return find.all();
}
public static void create(Tools tools){
tools.save();
}
public static void delete(Long id) {
find.ref(id).delete();
}
}
