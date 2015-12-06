package controllers;

import com.google.common.io.Files;
import models.Product;
import models.Tag;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.With;
import views.html.products.details;
import views.html.products.list;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static play.mvc.Http.MultipartFormData;


/**
 * Created by Meaks on 12/5/2015.
 */

@With(CatchAction.class)
public class Products extends Controller {

    private static final Form<Product> productForm = Form.form(Product.class);

    public  Result index() {
        return redirect(routes.Products.list(1));
    }

    public  Result list(Integer page) {
        Set<Product> products = Product.findAll();
        return ok(list.render(products));
    }

    public  Result newProduct() {
        return ok(details.render(productForm));
    }

    public Result details(Product product) {
        Form<Product> filledForm = productForm.fill(product);
        return ok(details.render(filledForm));
    }

    public  Result save() {
        MultipartFormData body = request().body().asMultipartFormData();
        Form<Product> boundForm = productForm.bindFromRequest();
        if(boundForm.hasErrors()) {
            flash("error", "Please correct the form below.");
            return badRequest(details.render(boundForm));
        }
        Product product = boundForm.get();

        MultipartFormData.FilePart part = body.getFile("picture");
        if(part != null) {
            File picture = part.getFile();

            try {
                product.picture = Files.toByteArray(picture);
            } catch (IOException e) {
                return internalServerError("Error reading file upload");
            }
        }

        List<Tag> tags = new ArrayList<Tag>();
        for (Tag tag : product.tags) {
            if (tag.id != null) {
                tags.add(Tag.findById(tag.id));
            }
        }
        product.tags = tags;

        product.save();
        flash("success",
                String.format("Successfully added product %s", product));

        return redirect(routes.Products.list(1));
    }

    public  Result picture(String ean) {
        final Product product = Product.findByEan(ean);
        if(product == null) return notFound();
        return ok(product.picture);
    }
}
