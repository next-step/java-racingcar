package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String DELIMITER = "[,:]";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");


    private StringAddCalculator() {

    }

    public static int splitAndSum(String input) {
        if (isBlank(input)) {
            return 0;
        }
        return getSum(split(input));
    }

    private static boolean isBlank(String input) {
        return input == null || input.isBlank();
    }

    private static String[] splitIntoNumStrings(String input) {
        String[] tokens = splitWithDelimiter(input);
        for (String str : tokens) {
            validateNotNegative(str);
        }

        return tokens;
    }

    private static String[] splitWithDelimiter(String input) {
        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return input.split(DELIMITER);
    }

    private static void validateNotNegative(String str) {
        if (str.contains("-")) {
            throw new RuntimeException(ErrorMessage.NEGATIVE_NOT_SUPPORTED.toString());
        }
    }

    private static Integer[] split(String input) {
        String[] split = splitIntoNumStrings(input);

        Integer[] ints = new Integer[split.length];
        for (int i = 0; i < split.length; i++) {
            ints[i] = Integer.parseInt(split[i]);
        }
        return ints;
    }

    private static int getSum(Integer[] split) {
        var sum = 0;
        for (int num : split) {
            sum += num;
        }
        return sum;
    }

}
