package model;

import java.util.UUID;

/**
 * The type Earning
 *
 * contains: uuid, financeId, value
 */
public class Earning {

    private UUID uuid;
    private UUID financeId; // finance_id in db
    private double value;

    /**
     * Instantiates a new Earning.
     *
     * @param uuid the uuid
     * @param financeId the finance id
     * @param value the value
     */
public Earning(UUID uuid, UUID financeId, double value) {
        this.uuid = uuid;
        this.financeId = financeId;
        this.value = value;
    }

    /**
     * Gets uuid.
     *
     * @return the uuid
     */
public UUID getUuid() {
        return uuid;
    }

    /**
     * Sets uuid.
     *
     * @param uuid the uuid
     */
public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    /**
     * Gets finance id.
     *
     * @return the finance id
     */
public UUID getFinanceId() {
        return financeId;
    }

    /**
     * Sets finance id.
     *
     * @param id the id
     */
public void setFinanceId(UUID id) {
        this.financeId = id;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
public double getValue() {
        return value;
    }

  /**
   * Sets value.
   *
   * @param value the value
   */
  public void setValue(double value) {
        this.value = value;
    }
}
