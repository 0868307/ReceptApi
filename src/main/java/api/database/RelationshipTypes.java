package api.database;

import org.neo4j.graphdb.RelationshipType;

/**
 * Created by Wouter on 12/12/2015.
 */
public enum RelationshipTypes implements RelationshipType{
    NEEDS,
    EATS,
    USES,
    LIKES
}
