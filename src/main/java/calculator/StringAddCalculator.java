package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEAULT_DELIMITER = ",:";

    private StringAddCalculator() {
    }

    public static int getSum(String input) {
        return isEmpty(input) ? 0 : sum(getIntArray(getSplittedString(input)));
    }

    private static String[] getSplittedString(String input) {
        String customDelimiter = checkCustomDelimiter(input);
        return isEmpty(customDelimiter) ?
                getSplit(input, DEAULT_DELIMITER) :
                getSplit(getInputAfterDelimiter(input), customDelimiter);
    }

    private static String checkCustomDelimiter(String input) {
        Matcher matcher = getMatcher(input);
        return matcher.find() ? matcher.group(1) : "";
    }

    private static String getInputAfterDelimiter(String input) {
        Matcher matcher = getMatcher(input);
        return matcher.find() ? input.substring(matcher.group(0).length()) : "";
    }

    private static Matcher getMatcher(String input) {
        Pattern pattern = Pattern.compile("//(.*?)\\n(.*?)");
        return pattern.matcher(input);
    }

    private static String[] getSplit(String input, String delimiter) {
        return input.split("[" + delimiter + "]");
    }

    private static boolean isEmpty(String input) {
        return input == null || input.isBlank();
    }

    private static int sum(int[] numbers) {
        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }

    private static int[] getIntArray(String[] values) {
        int[] ints = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            if (!isEmpty(values[i]) && Integer.parseInt(values[i]) < 0) {
                throw new NumberFormatException("음수는 입력할 수 없습니다.");
            }
            ints[i] = isEmpty(values[i]) ? 0 : Integer.parseInt(values[i]);
        }
        return ints;
    }
}
