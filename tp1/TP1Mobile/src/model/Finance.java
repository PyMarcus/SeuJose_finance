package model;

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
    private int id;
    private String name;
    private String classification;
    private String date; // date event in db
    private LocalDateTime localTime; // date to save on db in db

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
