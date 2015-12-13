package database;

import api.Main;
import api.database.ProductDAO;
import api.database.RecipeDAO;
import api.database.UserDAO;
import api.objects.Product;
import api.objects.Recipe;
import api.objects.User;
import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class DatabaseTest {

    private HttpServer server;
    private WebTarget target;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test to see that the message "Got it!" is sent in the response.
     */
    @Test
    public void testProduct() {
        String name = "Kaas";
        List<Product> objectList;
        ProductDAO.create(name);
        objectList = ProductDAO.getByName(name);
        for(Product product : objectList){
            assertEquals(name,product.getName());
        }
    }

    @Test
    public void testRecipe() {
        String name = "Macaroni";
        List<Recipe> objectList;
        RecipeDAO.create(name);
        objectList = RecipeDAO.getByName(name);
        for(Recipe recipe : objectList){
            assertEquals(name,recipe.getName());
        }
    }
    @Test
    public void testUser() {
        String name = "Kees";
        List<User> objectList;
        UserDAO.create(name);
        objectList = UserDAO.getByName(name);
        for(User user : objectList){
            assertEquals(name,user.getName());
        }
    }
}
