package api.database;

import api.objects.User;
import org.neo4j.cypher.javacompat.ExecutionResult;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.neo4j.helpers.collection.IteratorUtil;

import java.util.*;

/**
 * Created by Wouter on 12/12/2015.
 */
public class UserDAO extends DatabaseAccessObject {
    public static final String NAME = "name";
    public static final String FACEBOOK_ID = "facebookid";
    public static void create(String name){
        Transaction transaction = null;
        try {
            transaction = getGraphDB().beginTx();
            String clsName = User.class.getSimpleName();
            Node item = getGraphDB().createNode(ItemTypes.USER);
            item.setProperty(NAME, name);
            transaction.success();
        } finally {
            if (transaction != null) {
                transaction.close();
            }
        }
    }
    public static void delete(User user){
    }
    public static List<User> getByName(String name){
        Map<String, Object> charParams = new HashMap<>();
        User user = null;
        List<User> userList = new ArrayList<>();
        charParams.put("_name", name);
        Transaction transaction = null;
        try {
            transaction = getGraphDB().beginTx();
            ExecutionResult result = getEngine().execute(
                    "MATCH (n:USER {name: {_name}}) RETURN n", charParams
            );
            Iterator<Node> columns = result.columnAs("n");
            for (Node node : IteratorUtil.asIterable(columns)) {
                long strId = node.getId();
                String strName = (String) node.getProperty("name");
                user = new User(strId,strName);
                userList.add(user);
            }
            transaction.success();
        } finally {
            if (transaction != null) {
                transaction.close();
            }
        }
        return userList;
    }
    public static List<User> getById(Long id){
        return null;
    }
}
