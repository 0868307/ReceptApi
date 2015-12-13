package api.objects;

/**
 * Created by Wouter on 12/12/2015.
 */
public class User extends Neo4jObject {
    private String facebookid;

    public User(Long id, String name) {
        super(id, name);
    }

    public String getFacebookid() {
        return facebookid;
    }

    public void setFacebookid(String facebookid) {
        this.facebookid = facebookid;
    }
}
