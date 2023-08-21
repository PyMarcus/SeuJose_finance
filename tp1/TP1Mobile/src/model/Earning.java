package model;

import java.util.UUID;

/**
 * The type Earning
 *
 * contains:
 * uuid,
 * financeId,
 * value
 */
public class Earning {

    private UUID uuid;
    private UUID financeId; // finance_id in db
    private double value;

    public Earning(UUID uuid, UUID financeId, double value) {
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

    public void setFinanceId(UUID id) {
        this.financeId = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
