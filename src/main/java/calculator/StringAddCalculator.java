package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String SPLIT_PATTERN = "//(.)\n(.*)";
    private static final String SPLIT_SEPARATOR = ",|:";

    public static int splitAndSum(String input) {
        if (input == null || input.isBlank()) {
            return 0;
        }

        String[] inputArray = splitByPattern(input);

        return sumIntArray(toInts(inputArray));
    }

    private static int sumIntArray(int[] ints) {
        int result = 0;

        for (int val : ints) {
            result += val;
        }

        return result;
    }

    private static int[] toInts(String[] strings) {
        int[] ints = new int[strings.length];

        for (int i = 0; i < strings.length; i++) {
            ints[i] = toInt(strings[i]);
        }

        return ints;
    }

    private static int toInt(String val) {
        int i = Integer.parseInt(val);

        if (i < 0) {
            throw new RuntimeException("음수는 합을 구할 수 없다.");
        }
        return i;
    }

    private static String[] splitByPattern(String input) {
        Matcher m = Pattern.compile(SPLIT_PATTERN).matcher(input);

        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return input.split(SPLIT_SEPARATOR);
    }
}
