package model;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * The type Finance
 *
 * contains:
 * uuid,
 * id,
 * name,
 * classification,
 * date.
 * localTime
 */
public class Finance {
    private UUID uuid;
    private String name;
    private String classification;
    private double valueSpend;
    private double valueEarn;
    private String date; // date event in db
    private LocalDateTime localTime; // date to save on db in db

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

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public double getValueSpend() {
        return valueSpend;
    }

    public void setValueSpend(double valueSpend) {
        this.valueSpend = valueSpend;
    }

    public double getValueEarn() {
        return valueEarn;
    }

    public void setValueEarn(double valueEarn) {
        this.valueEarn = valueEarn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public LocalDateTime getLocalTime() {
        return localTime;
    }

    public void setLocalTime(LocalDateTime localTime) {
        this.localTime = localTime;
    }
}
