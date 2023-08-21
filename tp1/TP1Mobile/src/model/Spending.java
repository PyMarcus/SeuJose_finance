package model;

import java.util.UUID;

/**
 * The type Spending
 *
 * contains:
 * uuid,
 * financeId,
 * value
 */
public class Spending {
    private UUID uuid;
    private UUID financeId; // finance_id in db
    private double value;

    public Spending(UUID uuid, UUID financeId, double value) {
        this.uuid = uuid;
        this.financeId = financeId;
        this.value = value;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getFinanceId() {
        return financeId;
    }

    public void getFinanceId(UUID id) {
        this.financeId = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
