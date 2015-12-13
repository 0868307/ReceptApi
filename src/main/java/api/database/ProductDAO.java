package api.database;

import api.objects.Product;
import api.objects.Recipe;
import api.objects.User;
import org.neo4j.cypher.javacompat.ExecutionResult;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.neo4j.helpers.collection.IteratorUtil;

import java.util.*;

/**
 * Created by Wouter on 12/12/2015.
 */
public class ProductDAO extends DatabaseAccessObject {
    public static final String NAME = "name";
    public static final String UNIT = "unit";
    public static void create(String name){
        Transaction transaction = null;
        try {
            transaction = getGraphDB().beginTx();
            String clsName = Product.class.getSimpleName();
            Node item = getGraphDB().createNode(ItemTypes.RECIPE);
            item.setProperty(NAME, name);
            transaction.success();
        } finally {
            if (transaction != null) {
                transaction.close();
            }
        }
    }
    public static void delete(Product product){

    }
    public static List<Product> getByName(String name){
        Map<String, Object> charParams = new HashMap<>();
        Product product = null;
        List<Product> productList = new ArrayList<>();
        charParams.put("_name", name);
        Transaction transaction = null;
        try {
            transaction = getGraphDB().beginTx();
            ExecutionResult result = getEngine().execute(
                    "MATCH (n:PRODUCT {name: {_name}}) RETURN n", charParams
            );
            Iterator<Node> columns = result.columnAs("n");
            for (Node node : IteratorUtil.asIterable(columns)) {
                long strId = node.getId();
                String strName = (String) node.getProperty("name");
                product = new Product(strId,strName);
                productList.add(product);
            }
            transaction.success();
        } finally {
            if (transaction != null) {
                transaction.close();
            }
        }
        return productList;
    }
    public static List<Product> getById(Long id){
        return null;
    }
    // hier komt een query die alle needs relaties terug haalt dus Recipe > Needs > Product
    public static List<Recipe> getAllRecipesWithProduct(Product product){
        return null;
    }
    // hier komt een query die alle users terug haalt die het product gegeten hebben
    // dus User > Eats > Recipe > Needs > Product
    public static List<User> getAllUsersWhoAteProduct(Product product){
        return null;
    }

}
