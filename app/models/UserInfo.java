package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Meaks on 12/1/2015.
 */
@Entity
public class UserInfo extends Model {

    @Id
    public String email;
    public String name;
    public String password;

    public UserInfo(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public static Finder<String,UserInfo> find = new Finder<String,UserInfo>(
            String.class, UserInfo.class
    );

    public static UserInfo authenticate(String email, String password){
        return find.where().eq("email", email)
                .eq("password", password).findUnique();
    }
}
