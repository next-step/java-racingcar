package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int DELIMITER_GROUP = 1;
    private static final int STRING_GROUP = 2;
    private static final String DEFAULT_DELIMITER_PATTERN = "[,:]";

    private StringAddCalculator() {

    }

    public static int splitAndSum(String str) {
        if (isEmptyString(str)) {
            return 0;
        }

        String[] strings = splitString(str);
        int[] numbers = parseStringToInts(strings);
        return sum(numbers);
    }

    private static boolean isEmptyString(String str) {
        return str == null || str.isEmpty();
    }

    private static String[] splitString(String str) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(str);
        if (matcher.find()) {
            String customDelimiter = matcher.group(DELIMITER_GROUP);
            return matcher.group(STRING_GROUP).split(customDelimiter);
        }

        return str.split(DEFAULT_DELIMITER_PATTERN);
    }

    private static int[] parseStringToInts(String[] strings) {
        int[] numbers = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            numbers[i] = parseInt(strings[i]);
        }
        return numbers;
    }

    private static int parseInt(String str) {
        int num = Integer.parseInt(str);
        validateNegative(num);

        return num;
    }

    private static void validateNegative(int num) {
        if (isNegative(num)) {
            throw new RuntimeException("음수가 포함되어 있습니다.");
        }
    }

    private static boolean isNegative(int num) {
        return num < 0;
    }

    private static int sum(int[] numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }

}
