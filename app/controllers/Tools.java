package controllers;


import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.Tools.*;

import java.util.List;

/**
 * Created by Meaks on 12/3/2015.
 */
public class Tools extends Controller {

    private static final Form<Tools> toolsForm = Form.form(Tools.class);
    private static  details;

    public static Result list() {
        List<Tools> tools = Tools.findAll();
        return ok(list.render(tools));
    }

    public static Result newTools() {
        return ok(details.render(toolsForm));
    }

    public static Result details(String place) {
        final Tools tools = Tools.findByPlace(place);
        if (tools == null) {
            return notFound(String.format("Tool %s does not exist", place));
        }

        Form<Tools> filledForm = toolsForm.fill(tools);
        return ok(details.render(filledForm));
    }

    private static controllers.Tools findByPlace(String place) {
    }

    public static Result save(){
        Form<Tools> boundForm = toolsForm.bindFromRequest();
        if(boundForm.hasErrors()){
            flash("ERROR", "You must complete the form");
            return badRequest(details.render(boundForm));
        }

        Tools tools = boundForm.get();
        tools.save();
        flash("successful", String.format("You added a tool %s", tools));

        return redirect(routes.Tools.list());
    }

    public static Result delete(String Place){
        final Tools tools = Tools.findByPlace(place);
        if(tools == null){
            return notFound(String.format("Tools %s does not exist", place));
        }
        Tools.remove(tools);
        return redirect(routes.Tools.list());
    }
}