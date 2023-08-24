package dao.impl;

import dao.SpendingDAO;
import database.ConnectionDB;
import model.Spending;
import util.FLogger;
import java.sql.*;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The type Spending dao.
 */
public class SpendingDAOImpl implements SpendingDAO {

    /**
     * The Flogger.
     */
Logger flogger = FLogger.getLogger();
    private String enviroment;

    /**
     * Instantiates a new Spending dao.
     *
     * @param enviroment the enviroment
     */
public SpendingDAOImpl(String enviroment) {
        this.enviroment = enviroment;
    }

    @Override
    public double getTotalSpendings() {
        Connection conn = null;
        double total = 0;
        final String SQL = "SELECT SUM(value) as total FROM spendings;";

        try {
            conn = ConnectionDB.getConnection(this.enviroment);

            flogger.log(Level.INFO, "Successfully connected into {0} database.", this.enviroment);

            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(SQL);

            while (result.next()) {
                total = result.getDouble("total");
            }

            flogger.log(Level.INFO, "Result from complete spendings: {0}", total);
            return total;
        } catch (SQLException err) {
            flogger.warning(err.toString());
        } finally {
            ConnectionDB.closeConnection(conn);
        }
        return total;
    }

    @Override
    public void createSpending(Spending spendig) {
        Connection conn = null;
        final String SQL = """
                           INSERT INTO 
                           \tspendings (uuid, finance_id, value) 
                           VALUES(?, ?, ?);""";

        try {
            conn = ConnectionDB.getConnection(this.enviroment);

            flogger.log(Level.INFO, "Successfully connected into {0} database.", this.enviroment);

            PreparedStatement statement = conn.prepareStatement(SQL);
            statement.setObject(1, spendig.getUuid());
            statement.setObject(2, spendig.getFinanceId());
            statement.setDouble(3, spendig.getValue());
            statement.executeUpdate();
            flogger.info("Spending has been Created!");
        } catch (SQLException err) {
            flogger.warning(err.toString());
        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public void removeSpending(UUID uuid) {
        Connection conn = null;
        final String SQL = """
                           DELETE FROM 
                           \tspendings WHERE finance_id = ?;""";

        try {
            conn = ConnectionDB.getConnection(this.enviroment);

            flogger.log(Level.INFO, "Successfully connected into {0} database.", this.enviroment);

            PreparedStatement statement = conn.prepareStatement(SQL);
            statement.setObject(1, uuid);
            statement.executeUpdate();
            flogger.info("Spending has been removed!");
        } catch (SQLException err) {
            flogger.warning(err.toString());
        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }
}
