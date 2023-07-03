package calculator;

import java.util.Arrays;

public class StringCalculator {

    public static int sum(String number) {
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

    private static String[] splitNumber(String number) {
        return number.split("[,:]");
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

}
