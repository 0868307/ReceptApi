package api.database;

import org.neo4j.cypher.javacompat.ExecutionEngine;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.kernel.impl.util.StringLogger;

import java.io.File;
import java.io.IOException;

/**
 * Created by Wouter on 12/12/2015.
 */
abstract class DatabaseAccessObject {
    private static final String DB ="data/neo4j";
    private static final String PROPERTIES = "neo4j.properties";
    private static final String LOGFILE = "logs/logdb.txt";

    private static GraphDatabaseService graphDatabaseService;
    private static ExecutionEngine engine;

    protected DatabaseAccessObject() {
    }

    protected static GraphDatabaseService getGraphDB() {
        if(graphDatabaseService == null) {
            GraphDatabaseFactory graphDatabaseFactory = new GraphDatabaseFactory();
            graphDatabaseService = graphDatabaseFactory
                    .newEmbeddedDatabaseBuilder(DB)
                    .loadPropertiesFromFile(PROPERTIES)
                    .newGraphDatabase();

        }
        return graphDatabaseService;
    }

    protected static ExecutionEngine getEngine() {
        if (engine == null) {
            engine = new ExecutionEngine(getGraphDB(), StringLogger.logger(getLogFile()));
        }
        return engine;
    }

    private static File getLogFile() {
        File logfile = new File(LOGFILE);
        if (!logfile.exists()) {
            try {
                logfile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return logfile;
    }
}
