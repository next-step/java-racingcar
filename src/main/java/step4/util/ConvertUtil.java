package step4.util;

import java.util.Set;

public class ConvertUtil {

    private static final String COMMA_AND_SPACE_DELIMITER = "[\\s,]+";

    public static StringBuilder convertNumToDash(int value) {
        StringBuilder sb = new StringBuilder();

        sb.append("-".repeat(Math.max(0, value)));
        return sb;
    }

    public static String[] splitStringToArray(String value) {
        return value.split(COMMA_AND_SPACE_DELIMITER);
    }

    public static String appendToString(Set<String> values) {
        StringBuilder sb = new StringBuilder();
        String delim = "";
        for (String value : values) {
            sb.append(delim);
            delim = ", ";
            sb.append(value);
        }
        return sb.toString();
    }

}
