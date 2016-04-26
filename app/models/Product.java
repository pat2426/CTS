package models;

import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Product extends Model {




    /*
     * Attributes
     */
    @Id
    public Long id;
    public Long show;
    @Constraints.Required
    public String ean;

    @Constraints.Required
    public String name;

    @Constraints.MinLength(value = 10)
    public String description;

    public boolean requested=false;

    public boolean borrowed = false;

    @OneToOne
    public User requestedby;

    @ManyToOne
    public User borrow;

    public byte[] picture;

    public static Finder<String,Product> find = new Finder<String,Product>( String.class, Product.class);

	/*
	 * Methods
	 */


    public String toString() {
        return String.format("%s - %s", ean, name, id);
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


}
