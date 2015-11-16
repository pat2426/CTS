package models;

/**
 * Created by Meaks on 11/15/2015.
 */

import com.avaje.ebean.Model;

import javax.persistence.Entity;

@Entity
public class User extends Model {

    public String email;
    public String password;
    public String fullname;
    public boolean isAdmin;

    public User(String email, String password, String fullname) {
        this.email = email;
        this.password = password;
        this.fullname = fullname;
    }

}
