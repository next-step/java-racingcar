package racingcar.util;

public class StringUtils {
    public static final String SEPARATOR = ",";

    public static String[] split(String str) {
        return str.split(SEPARATOR);
    }
}
