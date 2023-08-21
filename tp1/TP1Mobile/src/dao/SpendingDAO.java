package dao;

import model.Spending;
import java.util.UUID;
import java.util.Vector;

public interface SpendingDAO {

    public double getTotalSpendings();
    public void createSpending(Spending earning);
    public void removeSpending(UUID uuid);
}
