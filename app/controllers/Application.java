package controllers;


import models.Tools;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import static play.data.Form.form;


public class Application extends Controller {

    static Form<Tools> toolsForm = form(Tools.class);

    public  Result index() {

        return redirect(routes.Application.Tools());
    }

    public  Result Tools(){
        
        return ok(views.html.index.render(Tools.all(), toolsForm)
        );
    }
    public  Result newTools(){
        Form<Tools> filledForm = toolsForm.bindFromRequest();
        if(filledForm.hasErrors()){
            return badRequest(
                    views.html.index.render(Tools.all(), filledForm)
            );
        }else{
            Tools.create(filledForm.get());
            return redirect(routes.Application.Tools());
        }
    }
    public  Result deleteTools(Long id){
        Tools.delete(id);
        return redirect(routes.Application.Tools());
    }
}

