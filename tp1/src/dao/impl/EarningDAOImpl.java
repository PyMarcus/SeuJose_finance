package dao.impl;

import dao.EarningDAO;
import database.ConnectionDB;
import model.Earning;
import util.FLogger;
import java.sql.*;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The type Earning dao.
 */
public class EarningDAOImpl implements EarningDAO {

    /**
     * The Flogger.
     */
Logger flogger = FLogger.getLogger();
    private String enviroment;

    /**
     * Instantiates a new Earning dao.
     *
     * @param enviroment the enviroment
     */
public EarningDAOImpl(String enviroment) {
        this.enviroment = enviroment;
    }

    @Override
    public double getTotalEarnings() {
        Connection conn = null;
        double total = 0;
        final String SQL = "SELECT SUM(value) as total FROM earnigns;";

        try {
            conn = ConnectionDB.getConnection(this.enviroment);

            flogger.log(Level.INFO, "Successfully connected into {0} database.", this.enviroment);

            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(SQL);

            while (result.next()) {
                total = result.getDouble("total");
            }

            flogger.log(Level.INFO, "Result from complete earnings: {0}", total);
            return total;
        } catch (SQLException err) {
            flogger.warning(err.toString());
        } finally {
            ConnectionDB.closeConnection(conn);
        }
        return total;
    }

    @Override
    public void createEarning(Earning earning) {
        Connection conn = null;
        final String SQL = """
                           INSERT INTO 
                           \tearnigns (uuid, finance_id, value) 
                           VALUES(?, ?, ?);""";

        try {
            conn = ConnectionDB.getConnection(this.enviroment);

            flogger.log(Level.INFO, "Successfully connected into {0} database.", this.enviroment);

            PreparedStatement statement = conn.prepareStatement(SQL);
            statement.setObject(1, earning.getUuid());
            statement.setObject(2, earning.getFinanceId());
            statement.setDouble(3, earning.getValue());
            statement.executeUpdate();
            flogger.info("Earning has been Created!");
        } catch (SQLException err) {
            flogger.warning(err.toString());
        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    /**
     * @param uuid
     */
    @Override
    public void removeEarning(UUID uuid) {
        Connection conn = null;
        final String SQL = """
                           DELETE FROM 
                           \tearnigns WHERE finance_id = ?;""";

        try {
            conn = ConnectionDB.getConnection(this.enviroment);

            flogger.log(Level.INFO, "Successfully connected into {0} database.", this.enviroment);

            PreparedStatement statement = conn.prepareStatement(SQL);
            statement.setObject(1, uuid);
            statement.executeUpdate();
            flogger.info("Earning has been removed!");
        } catch (SQLException err) {
            flogger.warning(err.toString());
        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }
}
