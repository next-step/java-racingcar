package calculator;

import java.util.Objects;

public class Utils {

    public static long stringToLong(String s) {
        return Long.parseLong(s);
    }

    public static void checkEmpty(String s) {
        if (Objects.isNull(s) || s.isEmpty()) {
            throw new IllegalArgumentException("input is null or empty");
        }
    }

}
