package calculator;

import java.util.Arrays;

public class StringCalculator {

    public static int sum(String number) {
        return Arrays.stream(splitNumber(number))
            .mapToInt(Integer::parseInt)
            .sum();
    }

    private static String[] splitNumber(String number) {
        return number.split(",|:");
    }
}
