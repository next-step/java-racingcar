package racingcar.util;

public class StringUtil {
    public static final String DELIMITER = ",";

    public static String[] splitNames(String names) {
        return names.split(DELIMITER);
    }
}
