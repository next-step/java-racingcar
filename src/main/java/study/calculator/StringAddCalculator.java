package study.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");

    public int splitAndSum(String input) {
        boolean isAZeroResult = input == "" || input == null;

        if (isAZeroResult) {
            return 0;
        }

        String[] stringTypeNumbers = SplitAndGetStrings(input);
        return parseIntAndGetSum(stringTypeNumbers);
    }

    private int parseIntAndGetSum(String[] stringTypeNumbers) {
        int sum = 0;
        for (String stringTypeNumber : stringTypeNumbers) {
            sum += getParseInt(stringTypeNumber);
        }
        return sum;
    }

    private int getParseInt(String stringTypeNumber) throws RuntimeException {
        return validateNegativeNumber(Integer.parseInt(stringTypeNumber));
    }

    private int validateNegativeNumber(int number) {
        if (number < 0) {
            throw new NumberFormatException("For input string : " + number);
        }
        return number;
    }

    private String[] SplitAndGetStrings(String input) {
        String[] stringTypeNumbers;
        Matcher matcher = CUSTOM_PATTERN.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            stringTypeNumbers = matcher.group(2).split("\\" + customDelimiter);
        } else {
            stringTypeNumbers = input.split(",|:");
        }
        return stringTypeNumbers;
    }
}
