package dao.impl;

import dao.EarningDAO;
import database.ConnectionDB;
import model.Earning;
import model.Finance;
import util.FLogger;

import java.sql.*;
import java.util.UUID;
import java.util.Vector;
import java.util.logging.Logger;

public class EarningDAOImpl implements EarningDAO {
    Logger flogger = FLogger.getLogger();
    private String enviroment;

    public EarningDAOImpl(String enviroment) {
        this.enviroment = enviroment;
    }

    @Override
    public double getTotalEarnings(){
        Connection conn = null;
        double total = 0;
        final String SQL = "SELECT SUM(value) as total FROM earnigns;";

        try{
            conn = ConnectionDB.getConnection(this.enviroment);

            flogger.info("Successfully connected into " + this.enviroment + " database.");

            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(SQL);


            while (result.next()){
                total = result.getDouble("total");
            }

            flogger.info("Result from complete earnings: " + total);
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
    public void createEarning(Earning earning){
        Connection conn = null;
        final String SQL = "INSERT INTO \n" +
                "\tearnigns (uuid, finance_id, value) \n" +
                "VALUES(?, ?, ?);";

        try{
            conn = ConnectionDB.getConnection(this.enviroment);

            flogger.info("Successfully connected into " + this.enviroment + " database.");

            PreparedStatement statement = conn.prepareStatement(SQL);
            statement.setObject(1, earning.getUuid());
            statement.setObject(2, earning.getFinanceId());
            statement.setDouble(3, earning.getValue());
            statement.executeUpdate();
            flogger.info("Earning has been Created!");
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
    public void removeEarning(UUID uuid) {

    }
}
