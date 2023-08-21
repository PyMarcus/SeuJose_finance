package dao;

import model.Earning;
import java.util.UUID;
import java.util.Vector;

public interface EarningDAO {
    public double getTotalEarnings();
    public void createEarning(Earning earning);
    public void removeEarning(UUID uuid);
}
