package api.database;

import api.objects.Product;
import api.objects.Recipe;
import org.neo4j.cypher.javacompat.ExecutionResult;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.neo4j.helpers.collection.IteratorUtil;

import java.util.*;

/**
 * Created by Wouter on 12/12/2015.
 */
public class RecipeDAO extends DatabaseAccessObject {
    public static final String NAME = "name";
    public static final String STEPS = "steps";

    public static void create(String name){
        Transaction transaction = null;
        try {
            transaction = getGraphDB().beginTx();
            String clsName = Recipe.class.getSimpleName();
            Node item = getGraphDB().createNode(ItemTypes.RECIPE);
            item.setProperty(NAME, name);
            transaction.success();
        } finally {
            if (transaction != null) {
                transaction.close();
            }
        }
    }
    public static void delete(Recipe recipe){
    }
    public static List<Recipe> getByName(String name){
        Map<String, Object> charParams = new HashMap<>();
        Recipe recipe = null;
        List<Recipe> recipeList = new ArrayList<>();
        charParams.put("_name", name);
        Transaction transaction = null;
        try {
            transaction = getGraphDB().beginTx();
            ExecutionResult result = getEngine().execute(
                    "MATCH (n:RECIPE {name: {_name}}) RETURN n", charParams
            );
            Iterator<Node> columns = result.columnAs("n");
            for (Node node : IteratorUtil.asIterable(columns)) {
                long strId = node.getId();
                String strName = (String) node.getProperty("name");
                recipe = new Recipe(strId,strName);
                recipeList.add(recipe);
            }
            transaction.success();
        } finally {
            if (transaction != null) {
                transaction.close();
            }
        }
        return recipeList;
    }
    public static List<Recipe> getById(Long id){
        return null;
    }
    public static void addProduct(Product product,int amount){

    }
    // remove the complete relationship
    public static void removeProduct(Product product){

    }
    // change the amount in the relationship
    public static void removeProduct(Product product,int amount){

    }
}
