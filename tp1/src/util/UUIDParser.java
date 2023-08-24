package util;

import java.util.UUID;

/**
 * The type Uuid parser.
 */
public class UUIDParser {

    /**
     * Generate uuid (the pk of columns from the database).
     *
     * @return the uuid
     */
    public static UUID generateUUID() {
        return UUID.randomUUID();
    }

    /**
     * Compare uuid boolean.
     *
     * @param firstUUID the first uuid
     * @param secondUUID the second uuid
     * @return the boolean -> true if the first uuid is equals to second uuid
     */
    public static boolean compareUUID(UUID firstUUID, UUID secondUUID) {
        return firstUUID.equals(secondUUID);
    }
}
