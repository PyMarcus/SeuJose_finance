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
     * @return the local date time
     */
    public static LocalDateTime generateCurrentLocalTime(){
        return LocalDateTime.now();
    }

    /**
     * Parse datetime to string.
     *
     * @param date the date
     * @return the string
     */
    public static String parseDatetimeToString(LocalDateTime date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        return formatter.format(date);
    }
}
