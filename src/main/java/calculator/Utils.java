package calculator;

import java.util.Objects;

public class Utils {

    public static void checkNullOrEmpty(String str) {
        if (Objects.isNull(str) || str.isEmpty()) {
            throw new IllegalArgumentException("null or empty");
        }
    }
}
