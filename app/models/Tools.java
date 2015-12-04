package models;

import play.data.validation.Constraints;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Meaks on 12/3/2015.
 */
public class Tools {
    private static List<Tools> tools;

    @Constraints.Required
    public String place;
    @Constraints.Required
    public String name;
    public String description;

    public Tools(){
    }

    public Tools(String place, String name, String description){
        this.place = place;
        this.name = name;
        this.description = description;
    }

    public String toString(){
        return String.format("%s - %s", place,name);
    }

    public static List<Tools> findAll(){
        return new ArrayList<Tools>(tools);
    }

    public static Tools findByPlace(String place){
        for(Tools candidate : tools){
            if(candidate.place.equals(place)){
                return candidate;
            }
        }
        return null;
    }

    public static List<Tools> findByName(String term){
        final List<Tools> results = new ArrayList<Tools>();
        for(Tools candidate : tools){
            if(candidate.name.toLowerCase().contains(term.toLowerCase())){
                results.add(candidate);
            }
        }
        return results;
    }

    public static boolean remove(Tools tools){
        return tools.remove(tools);
    }

    public void save(){
        tools.remove(findByPlace(this.place));
        tools.add(this);
    }
}
