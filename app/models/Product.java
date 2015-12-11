package models;

import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.LinkedList;
import java.util.List;


@Entity
public class Product extends Model {

    /*
     * Constructor
     */
    public Product(String ean, String name, String description, List<Tag> tags) {
        super();
        this.ean = ean;
        this.name = name;
        this.description = description;
        this.tags = tags;
    }

    public Product(String ean, String name, String description) {
        super();
        this.ean = ean;
        this.name = name;
        this.description = description;
    }


    /*
     * Attributes
     */
    @Id
    @Constraints.Required
    public String ean;

    @Constraints.Required
    public String name;

    @Constraints.MinLength(value = 10)
    public String description;

    @ManyToMany(cascade= CascadeType.ALL)
    public List<Tag> tags = new LinkedList<Tag>();

    public byte[] picture;

    public static Finder<String,Product> find = new Finder<String,Product>( String.class, Product.class);

	/*
	 * Methods
	 */


    public String toString() {
        return String.format("%s - %s", ean, name);
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }



}
