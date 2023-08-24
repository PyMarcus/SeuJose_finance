package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.configuration2.INIConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import util.FLogger;

/**
 * The type Connection db that create a connection with postgres database.
 *
 * Basically, this class creates a connection in a context manager, to make it
 * easier to end the use of resources when finished.
 */
public class ConnectionDB {

    private static final String JDBC_URL_DEVELOPEMENT = "jdbc:postgresql://localhost:5432/financasdojose_db";
    private static final String JDBC_URL_PRODUCTION = "jdbc:postgresql://localhost:5432/financasdojose_db";
    private static String USER;
    private static String PASSWORD;

    /**
     * Gets connection.
     *
     * @param enviroment the enviroment must be production or development
     * @return the connection type Connection
     * @throws SQLException the sql exception
     */
    public static Connection getConnection(String enviroment) throws SQLException {
        Logger logger = FLogger.getLogger();
        logger.log(Level.INFO, "Connected with {0}", enviroment);

        getCredentials(enviroment);
        return switch (enviroment) {
            case "production" -> DriverManager.getConnection(JDBC_URL_PRODUCTION, USER, PASSWORD);
            default -> DriverManager.getConnection(JDBC_URL_DEVELOPEMENT, USER, PASSWORD);
        };
    }

    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException err) {
                err.printStackTrace();
            }
        }
    }

    /**
     * Sets the user and password from local .ini file.
     *
     * @param enviroment the enviroment must be production or development
     */
    private static void getCredentials(String enviroment) {
        Configurations configurations = new Configurations();

        try {
            INIConfiguration iniConfiguration = configurations.ini("database/financasdojose_db.ini");

            USER = iniConfiguration.getString(enviroment + ".user");
            PASSWORD = iniConfiguration.getString(enviroment + ".password");

        } catch (ConfigurationException err) {
            throw new RuntimeException(err);
        }
    }
}
