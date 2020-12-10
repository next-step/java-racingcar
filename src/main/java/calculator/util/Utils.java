package calculator.util;

import java.util.Objects;

public class Utils {

    public static void checkNullOrEmpty(String str) {
        if (Objects.isNull(str) || str.isEmpty()) {
            throw new IllegalArgumentException("null or empty");
        }
    }

    public static long stringToLong(String str) {
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            throw new IllegalArgumentException("문자열을 정수로 변환할 수 없습니다. " + e.getMessage());
        }
    }

}
