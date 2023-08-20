import database.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import util.FLogger;

public class Main {
    public static void main(String[] args){
        Connection connection = null;
        try{
            connection = ConnectionDB.getConnection("production");
            Logger log = FLogger.getLogger();
            log.info("Success!");
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select * from finances;");
            while (result.next()){
                System.out.println(result.getString("name"));
            }
        }catch (SQLException err){
            err.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(connection);
        }
    }
}
