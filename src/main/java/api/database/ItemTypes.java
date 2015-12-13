package api.database;

import org.neo4j.graphdb.Label;

/**
 * Created by Wouter on 12/12/2015.
 */
public enum ItemTypes implements Label {
    PRODUCT,
    RECIPE,
    USER
}
