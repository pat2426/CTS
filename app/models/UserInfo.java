package models;

import controllers.Session;
import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

/**
 * Created by Meaks on 12/1/2015.
 */
@Entity
public class UserInfo extends Model {

    @Id
    public Long id;

    @Constraints.Required
    public String email;

    @Constraints.Required
    public String name;

    @Constraints.Required
    public String password;

    @Constraints.Required
    public String username;

    public UserInfo(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.username = username;
    }


    public static Finder<String,UserInfo> find = new Finder(
            String.class, UserInfo.class);
    public static List<UserInfo> all(){
        return find.all();
    }

    public static UserInfo findByEmail(String email){
        return find.where().eq("email", email).findUnique();
    }

    public static UserInfo findById(Long id) {
        return find.ref(id);
    }


    public static void delete(Long id) {
        findById(id).delete();
    }

    public void update(UserInfo userInfo) {
        userInfo.password = Session.encryptPassword(userInfo.password);
        userInfo.update(this.id);
    }

    public static UserInfo authenticate(String useremail, String password) {
        UserInfo userInfo = find.where().eq("useremail", useremail).findUnique();
        if (Session.checkPassword(password, userInfo.password)) return userInfo;
        return null;
    }

}
