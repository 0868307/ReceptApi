package api.objects;

/**
 * Created by Wouter on 12/12/2015.
 */
public abstract class Neo4jObject {
    private Long id;
    private String name;

    public Neo4jObject(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
