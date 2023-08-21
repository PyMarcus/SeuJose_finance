package dao.impl;

import dao.FinanceDAO;
import model.Finance;

import java.sql.*;
import java.util.UUID;
import java.util.logging.Logger;
import database.ConnectionDB;
import util.FLogger;
import java.util.Vector;

public class FinanceDAOImpl implements FinanceDAO {
    Logger flogger = FLogger.getLogger();
    private String enviroment;
    private int size;

    public FinanceDAOImpl(String enviroment){
        this.enviroment = enviroment;
    }

    @Override
    public Vector<Finance> getAllFinances() {
        Connection conn = null;
        Vector<Finance> finances = new Vector<>();

        final String SQL = "select \n" +
                "\tf.uuid as uuid,\n" +
                "\tf.name as name,\n" +
                "\tf.classification as classification,\n" +
                "\tcoalesce(s.value, 0) as spend_value,\n" +
                "\tcoalesce(e.value, 0) as earn_value,\n" +
                "\tf.date as date_event,\n" +
                "\tf.created_at as date_save_on_db\n" +
                "from \n" +
                "\tfinances f\n" +
                "left join \n" +
                "\tspendings s on f.uuid = s.finance_id\n" +
                "left join \n" +
                "\tearnigns e on f.uuid = e.finance_id\n" +
                "order by f.name, f.created_at asc;";


        try{
            conn = ConnectionDB.getConnection(this.enviroment);

            flogger.info("Successfully connected into " + this.enviroment + " database.");

            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(SQL);


            while (result.next()){
                Finance finance = new Finance(
                        (UUID) result.getObject("uuid"),
                        result.getString("name"),
                        result.getString("classification"),
                        result.getDouble("spend_value"),
                        result.getDouble("earn_value"),
                        result.getString("date_event"),
                        result.getTimestamp("date_save_on_db").toLocalDateTime()
                );

                finances.add(finance);
            }

            flogger.info("Result from complete finances: " + finances.size());
            this.size = finances.size();
        }
        catch (SQLException err){
            flogger.warning(err.toString());
        }
        finally {
            ConnectionDB.closeConnection(conn);
        }

        return finances;
    }

    @Override
    public Finance getFinance(UUID uuid) {
        return null;
    }

    public int getSize(){
        return this.size;
    }

    @Override
    public Finance getFinance(long id) {
        return null;
    }

    @Override
    public void createFinance(Finance finace) {
        Connection conn = null;
        final String SQL = "INSERT INTO \n" +
                            "\tfinances (uuid, name, classification, date, created_at) \n" +
                            "VALUES(?, ?, ?, ?, ?);";

        try{
            conn = ConnectionDB.getConnection(this.enviroment);

            flogger.info("Successfully connected into " + this.enviroment + " database.");

            PreparedStatement statement = conn.prepareStatement(SQL);
            statement.setObject(1, finace.getUuid());
            statement.setString(2, finace.getName());
            statement.setString(3, finace.getClassification());
            statement.setString(4, finace.getDate());
            statement.setTimestamp(5, Timestamp.valueOf(finace.getLocalTime()));
            statement.executeUpdate();
            flogger.info("Finance has been Created!");
        }
        catch (SQLException err){
            flogger.warning(err.toString());
        }
        finally {
            ConnectionDB.closeConnection(conn);
        }

    }

    @Override
    public void removeFinance(UUID uuid) {

    }

    @Override
    public void removeFinance(long id) {

    }
}
