package model;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * The type Finance
 *
 * contains: uuid, id, name, classification, date. localTime
 */
public class Finance {

    private UUID uuid;
    private String name;
    private String classification;
    private double valueSpend;
    private double valueEarn;
    private String date;             // date event in db
    private LocalDateTime localTime; // date to save on db in db

    /**
     * Instantiates a new Finance.
     *
     * @param uuid the uuid
     * @param name the name
     * @param classification the classification
     * @param valueSpend the value spend
     * @param valueEarn the value earn
     * @param date the date
     * @param localTime the local time
     */
public Finance(UUID uuid,
            String name,
            String classification,
            double valueSpend,
            double valueEarn,
            String date,
            LocalDateTime localTime) {

        this.uuid = uuid;
        this.name = name;
        this.classification = classification;
        this.valueSpend = valueSpend;
        this.valueEarn = valueEarn;
        this.date = date;
        this.localTime = localTime;
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
     * Gets value spend.
     *
     * @return the value spend
     */
public double getValueSpend() {
        return valueSpend;
    }

    /**
     * Sets value spend.
     *
     * @param valueSpend the value spend
     */
public void setValueSpend(double valueSpend) {
        this.valueSpend = valueSpend;
    }

    /**
     * Gets value earn.
     *
     * @return the value earn
     */
public double getValueEarn() {
        return valueEarn;
    }

    /**
     * Sets value earn.
     *
     * @param valueEarn the value earn
     */
public void setValueEarn(double valueEarn) {
        this.valueEarn = valueEarn;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets classification.
     *
     * @return the classification
     */
public String getClassification() {
        return classification;
    }

    /**
     * Sets classification.
     *
     * @param classification the classification
     */
public void setClassification(String classification) {
        this.classification = classification;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
public String getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
public void setDate(String date) {
        this.date = date;
    }

    /**
     * Gets local time.
     *
     * @return the local time
     */
public LocalDateTime getLocalTime() {
        return localTime;
    }

  /**
   * Sets local time.
   *
   * @param localTime the local time
   */
  public void setLocalTime(LocalDateTime localTime) {
        this.localTime = localTime;
    }
}
