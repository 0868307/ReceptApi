package api.objects;

/**
 * Created by Wouter on 12/12/2015.
 */
public class Product extends Neo4jObject {
    private String unit; // unit( kg,L) neccesary for grocery list

    public Product(Long id, String name) {
        super(id, name);
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

}
