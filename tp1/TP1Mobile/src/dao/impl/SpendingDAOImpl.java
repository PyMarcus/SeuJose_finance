package dao.impl;

import dao.SpendingDAO;
import database.ConnectionDB;
import model.Spending;
import util.FLogger;

import java.sql.*;
import java.util.UUID;
import java.util.logging.Logger;

public class SpendingDAOImpl implements SpendingDAO {
    Logger flogger = FLogger.getLogger();
    private String enviroment;

    public SpendingDAOImpl(String enviroment) {
        this.enviroment = enviroment;
    }

    @Override
    public double getTotalSpendings(){
        Connection conn = null;
        double total = 0;
        final String SQL = "SELECT SUM(value) as total FROM spendings;";

        try{
            conn = ConnectionDB.getConnection(this.enviroment);

            flogger.info("Successfully connected into " + this.enviroment + " database.");

            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(SQL);


            while (result.next()){
                total = result.getDouble("total");
            }

            flogger.info("Result from complete spendings: " + total);
            return total;
        }
        catch (SQLException err){
            flogger.warning(err.toString());
        }
        finally {
            ConnectionDB.closeConnection(conn);
        }
        return total;
    }

    @Override
    public void createSpending(Spending spendig){
        Connection conn = null;
        final String SQL = "INSERT INTO \n" +
                "\tspendings (uuid, finance_id, value) \n" +
                "VALUES(?, ?, ?);";

        try{
            conn = ConnectionDB.getConnection(this.enviroment);

            flogger.info("Successfully connected into " + this.enviroment + " database.");

            PreparedStatement statement = conn.prepareStatement(SQL);
            statement.setObject(1, spendig.getUuid());
            statement.setObject(2, spendig.getFinanceId());
            statement.setDouble(3, spendig.getValue());
            statement.executeUpdate();
            flogger.info("Spending has been Created!");
        }
        catch (SQLException err){
            flogger.warning(err.toString());
        }
        finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    /**
     * @param uuid
     */
    @Override
    public void removeSpending(UUID uuid) {

    }
}
