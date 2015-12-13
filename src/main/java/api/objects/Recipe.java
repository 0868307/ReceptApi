package api.objects;

import java.util.List;

/**
 * Created by Wouter on 12/12/2015.
 */
public class Recipe extends Neo4jObject {
    private List steps;
    public static enum CategoryType {
        HEALTHY,
        QUICK,
        MEXICAN,
        AMERICAN,
        DUTCH
    }
    private List category; // types of categories
    public Recipe(Long id, String name) {
        super(id, name);
    }

    public List getSteps() {
        return steps;
    }

    public void setSteps(List steps) {
        this.steps = steps;
    }
}
