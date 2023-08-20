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
    private int financeId; // finance_id in db
    private double value;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public int getId() {
        return financeId;
    }

    public void setId(int id) {
        this.financeId = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
