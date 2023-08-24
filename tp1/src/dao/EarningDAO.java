package dao;

import model.Earning;
import java.util.UUID;

public interface EarningDAO {
    public double getTotalEarnings();
    public void createEarning(Earning earning);
    public void removeEarning(UUID uuid);
}
