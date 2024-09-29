package stringaddcalculator;

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

        Map<String, String> delimiterAndTextMap = getCustomDelimiterAndText(DEFAULT_DELIMITER, text);
        String confirmDelimiter = delimiterAndTextMap.get("delimiter");
        String confirmText = delimiterAndTextMap.get("text");

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

    private static Map<String, String> getCustomDelimiterAndText(String delimiter, String text) {
        Map<String, String> result = new HashMap<>();

        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(text);

        if (matcher.find()) {
            result.put("delimiter", matcher.group(1));
            result.put("text", matcher.group(2));
            return result;
        }

        result.put("delimiter", delimiter);
        result.put("text", text);
        return result;
    }
}
