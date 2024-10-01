package stringaddcalculator;

import stringaddcalculator.dto.CalculatorDto;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_REGEXP = "//(.)\\n(.*)";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER_REGEXP);

    private static final int DEFAULT_CALCULATOR_VALUE = 0;


    private StringAddCalculator() {
    }

    public static int splitAndSum(String text) {

        if (text == null) return DEFAULT_CALCULATOR_VALUE;

        CalculatorDto calculatorDto = getCustomDelimiterAndText(DEFAULT_DELIMITER, text);
        String confirmDelimiter = calculatorDto.delimiter();
        String confirmText = calculatorDto.text();

        if (confirmText.isEmpty()) return DEFAULT_CALCULATOR_VALUE;

        return getSum(toInts(getSplitByDelimiter(confirmDelimiter, confirmText)));
    }

    private static String[] getSplitByDelimiter(String delimiter, String text) {
        return text.split(delimiter);
    }

    private static int[] toInts(String[] stringNumbers) {
        int[] result = new int[stringNumbers.length];
        for (int i = 0; i < stringNumbers.length; i++) {
            result[i] = toInt(stringNumbers[i]);
        }
        return result;
    }

    private static int toInt(String stringNumber) {
        int parseIntNumber = parse(stringNumber);
        validateNegativeNumber(parseIntNumber);
        return parseIntNumber;
    }

    private static void validateNegativeNumber(int number) {
        if (number < 0) throw new IllegalArgumentException("음수 입력");
    }

    private static int parse(String token) throws NumberFormatException {
        return Integer.parseInt(token);
    }

    private static int getSum(int[] numbers) throws RuntimeException {
        int result = DEFAULT_CALCULATOR_VALUE;

        for (int number : numbers) {
            result += number;
        }

        return result;
    }

    private static CalculatorDto getCustomDelimiterAndText(String delimiter, String text) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(text);

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String customText = matcher.group(2);
            return new CalculatorDto(customDelimiter, customText);
        }

        return new CalculatorDto(delimiter, text);
    }
}
