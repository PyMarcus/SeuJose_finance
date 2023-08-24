package dao;

import model.Finance;
import java.util.UUID;
import java.util.Vector;

public interface FinanceDAO {
    public Vector<Finance> getAllFinances();
    public Finance getFinance(UUID uuid);
    public Finance getFinance(long id);
    public void createFinance(Finance earning);
    public void removeFinance(UUID uuid);

}
