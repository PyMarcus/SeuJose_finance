package dao;

import model.Spending;
import java.util.UUID;

public interface SpendingDAO {

    public double getTotalSpendings();
    public void createSpending(Spending earning);
    public void removeSpending(UUID uuid);
}
