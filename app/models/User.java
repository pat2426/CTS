package models;

/**
 * Created by Meaks on 11/15/2015.
 */

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User extends Model {

    @Id
    public String email;
    public String password;
    public String username;
    public long id;
    public boolean isAdmin;

    public User(String email, String password, String username) {
        this.email = email;
        this.password = password;
        this.username = username;
    }


    public static Finder<String,User> find = new Finder<String,User>(
            String.class, User.class
    );

    public static User authenticate(String email, String password) {
        return find.where().eq("email", email)
                .eq("password", password).findUnique();
    }
}
