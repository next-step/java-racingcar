package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private static final int DELIMITER_IDX = 1;
    private static final int NUMBERS_IDX = 2;
    private static final Pattern CUSTOM_DELIMITER = Pattern.compile("//(.)\n(.*)");

    public static int cal(String input) {
        if (isBlank(input)) {
            return 0;
        }
        if (containsDelimiter(input)){
            return sum(parseArray(split(input, "[,:]")));
        }
        Matcher m = compilePattern(input);
        if (m.find()) {
            return sum(parseArray(split(m.group(NUMBERS_IDX), m.group(DELIMITER_IDX))));
        }

        return parse(input);
    }

    private static Matcher compilePattern(String input) {
        return CUSTOM_DELIMITER.matcher(input);
    }

    private static boolean containsDelimiter(String input) {
        return input.contains(",") || input.contains(":");
    }

    private static int sum(int[] values) {
        int sum = 0;
        for (int value : values) {
            validateNegative(value);
            sum += value;
        }
        return sum;
    }

    private static void validateNegative(int value) {
        if(value < 0) {
            throw new NumberFormatException("For input string: " + value);
        }
    }

    private static String[] split(String input, String delimiter) {
        return input.split(delimiter);
    }

    private static int parse(String input) {
        return Integer.parseInt(input);
    }

    private static int[] parseArray(String[] values) {
        int [] parsed = new int[values.length];
        for(int i = 0; i< values.length ; i++){
            parsed[i] = parse(values[i]);
        }
        return parsed;
    }

    private static boolean isBlank(String input) {
        return input == null || input.isEmpty();
    }
}
