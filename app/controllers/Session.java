package controllers;

import play.mvc.Controller;

/**
 * Created by Meaks on 12/5/2015.
 */
public class Session extends Controller {

    public static class Login{
        public String useremail;
        public String password;
    }
}
