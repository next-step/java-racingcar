package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String SPLIT_DELIMETER = ",|:";
    private static final Pattern CUSTOM_DELIMETER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final Pattern INVALID_PATTERN = Pattern.compile("^(?!.*[,:]).*(?<!//(.*)\\n(.*))$");
    private static final int RETURN_ZERO = 0;
    public static int splitAndSum(String text) {

        if (isNullOrEmpty(text)) {
            return RETURN_ZERO;
        }

        invalidCheck(text);

        String[] tokens = getTokens(text);

        int resultSum = tokensCalcSum(tokens);

        return resultSum;
    }

    private static String[] getTokens(String text) {
        String[] tokens = splitText(text);

        Matcher m = CUSTOM_DELIMETER_PATTERN.matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            tokens= m.group(2).split(customDelimiter);
        }

        return tokens;
    }

    private static int tokensCalcSum(String[] tokens) {
        return Arrays.stream(tokens).mapToInt(StringAddCalculator::parseInteger).sum();
    }

    private static String[] splitText(String text) {
        String[] tokens = text.split(SPLIT_DELIMETER);
        return tokens;
    }

    private static void invalidCheck(String text) {
        if (INVALID_PATTERN.matcher(text).find() && text.length() != 1) {
            throw new InvalidTextException("문자열 형식이 올바르지 않습니다.");
        }
    }

    private static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static int parseInteger(String token) {
        int number = Integer.valueOf(token);

        if (number < 0) {
            throw new NegativeNumberException("음수를 입력할수 없습니다.");
        }

        return number;
    }
}
