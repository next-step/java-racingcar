package utils;

import java.util.Collection;
import java.util.StringJoiner;

public class StringUtils {

    private StringUtils() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static boolean isPositiveNumeric(String value) {
        return value.chars().allMatch(Character::isDigit) && Integer.parseInt(value) >= 0;
    }

    public static boolean isEmpty(String text) {
        return text == null || text.isEmpty();
    }

    public static String join(Collection<String> collection, String separator) {
        StringJoiner joiner = new StringJoiner(separator);
        for (String s : collection) {
            joiner.add(s);
        }
        return joiner.toString();
    }
}
