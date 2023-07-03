package calculator;

import java.util.Arrays;
import java.util.Objects;

public class StringCalculator {

    private StringCalculator() {
        throw new UnsupportedOperationException("Cannot invoke constructor \"StringCalculator()\"");
    }

    public static int sum(String number) {
        if (Objects.isNull(number) || number.isBlank()) {
            return 0;
        }
        preAssert(number);
        return Arrays.stream(splitNumber(number))
            .mapToInt(Integer::parseInt)
            .sum();
    }

    private static void preAssert(String number) {
        assertNumber(number);
        assertPositiveNumber(number);
    }

    private static void assertNumber(String number) {
        boolean isPresent = Arrays.stream(splitNumber(number))
            .anyMatch(StringCalculator::isText);
        if (isPresent) {
            throw new IllegalArgumentException("숫자가 아닌값이 들어왔습니다. \"" + number + "\"");
        }
    }

    private static boolean isText(String c) {
        try {
            Integer.parseInt(c);
            return false;
        } catch (NumberFormatException numberFormatException) {
            return true;
        }
    }

    private static void assertPositiveNumber(String number) {
        boolean isPresent = Arrays.stream(splitNumber(number))
            .anyMatch(n -> Integer.parseInt(n) < 0);
        if (isPresent) {
            throw new IllegalArgumentException("숫자가 아닌값이 들어왔습니다. \"" + number + "\"");
        }
    }

    private static String[] splitNumber(String number) {
        return number.split("[,:]");
    }

}
