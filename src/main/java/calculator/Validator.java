package calculator;

import java.util.Arrays;

public class Validator {
    public static void isValidateNum(String[] values) {
        boolean hasNegative = Arrays.stream(values)
                .mapToInt(Integer::parseInt)
                .anyMatch(num -> num < 0);

        if (hasNegative) throw new RuntimeException();
    }

    public static boolean isBlank(String text) {
        if (text.isBlank()) return false;
        return true;
    }
}
