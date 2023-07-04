package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static int sum(String input) {
        if (isBlank(input)) {
            return 0;
        }
        return stringToSum(input);
    }

    private static int stringToSum(String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        String delimiter = ",|:";

        if (m.find()) {
            delimiter = m.group(1);
            input = m.group(2);
        }

        return Arrays.stream(input.split(delimiter))
                .mapToInt(Integer::valueOf)
                .sum();
    }

    private static boolean isBlank(String input) {
        return input == null || input.isBlank();
    }
}
