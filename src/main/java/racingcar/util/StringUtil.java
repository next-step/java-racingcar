package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class StringUtil {

    private final static String DELIMITER = ",";
    private final static String STATE = "-";

    public static List<String> splitString(String s) {
        return Arrays.asList(s.split(DELIMITER));
    }

    public static String makeStateLine(Integer r) {
        return String.valueOf(new char[r])
                .replace("\0", STATE);
    }
}
