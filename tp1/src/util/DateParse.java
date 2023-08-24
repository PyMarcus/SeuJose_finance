package util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The type Dateparse to solve date works.
 */
public class DateParse {

    /**
     * Generate current local time.
     *
     * @return the current local time
     */
    public static LocalDateTime generateCurrentLocalTime() {
        return LocalDateTime.now();
    }

    /**
     * Parse LocalDateTime to string.
     *
     * @param date the date
     * @return the string
     */
    public static String parseDatetimeToString(LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        return formatter.format(date);
    }

    /**
     * Parse LocalDateTime to string to create rotative logs
     *
     * @param date the date
     * @return the string
     */
    public static String parseDatetimeToStringLog(LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd_MM_YYYY");
        return formatter.format(date);
    }
}
