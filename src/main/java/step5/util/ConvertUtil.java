package step5.util;

import java.util.Set;

public class ConvertUtil {

    private static final String COMMA_AND_SPACE_DELIMITER = "[\\s,]+";
    private static final String COMMA_SEPARATOR = ",";

    public static StringBuilder convertNumToDash(int value) {
        StringBuilder sb = new StringBuilder();
        sb.append("-".repeat(Math.max(0, value)));
        return sb;
    }

    public static String[] splitStringToArray(String value) {
        return value.split(COMMA_AND_SPACE_DELIMITER);
    }

    public static String joinStringByComma(Set<String> values) {
        return String.join(COMMA_SEPARATOR, values);
    }
}
