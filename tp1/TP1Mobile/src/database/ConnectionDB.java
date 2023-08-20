package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.commons.configuration2.INIConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

/**
 * The type Connection db that create
 * a connection with postgres database.
 *
 * Basically, the idea is to create a context manager,
 * to force the end of using bank resources.
 */
public class ConnectionDB{

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
    public static Connection getConnection(String enviroment) throws SQLException{
        getCredentials(enviroment);
        switch (enviroment){
            case "production":
                return DriverManager.getConnection(JDBC_URL_PRODUCTION, USER, PASSWORD);
            default:
                return DriverManager.getConnection(JDBC_URL_DEVELOPEMENT, USER, PASSWORD);
        }
    }

    public static void closeConnection(Connection conn){
        if(conn != null) {
            try {
                conn.close();
            }catch (SQLException err){
                err.printStackTrace();
            }
        }
    }

    /**
     * Sets the user and password from local .ini file.
     *
     * @param enviroment the enviroment must be production or development
     */
    private static void getCredentials(String enviroment){
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