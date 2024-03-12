package stringcalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static StringCalculator stringCalculator = new StringCalculator();
    private static final String NUMERIC_REGEXP = "\\d";
    private static final String DEFAULT_SEPARATOR = ",|:";
    private static final String CUSTOM_SEPARATOR = "//(.)\n(.*)";
    private static final int PATTERN_GROUP_NUM = 1;
    private static final int INPUT_GROUP_NUM = 2;
    private StringCalculator() {}

    public static StringCalculator getInstance() {
        return stringCalculator;
    }

    public int calculate(String input) {
        if (nullCheck(input)) {
            return 0;
        }

        input = deleteBlank(input);

        if (isNumeric(input)) {
            return Integer.parseInt(input);
        }

        String[] tokens = splitString(input);

        if (!isValidTokens(tokens)) {
            throw new RuntimeException("숫자를 입력해주세요");
        }

        return sumTokens(tokens);

    }

    private int sumTokens(String[] tokens) {
        int result = 0;
        for (String token : tokens) {
            result += Integer.parseInt(token);
        }
        return result;
    }

    public boolean isValidTokens(String[] tokens) {
        long count = Arrays.stream(tokens)
                .filter(token -> !token.startsWith("-"))
                .filter(this::isNumeric)
                .count();
        return count == tokens.length;
    }


    public boolean isNumeric(String input) {
        return Pattern.matches(NUMERIC_REGEXP, input);
    }

    public String deleteBlank(String input) {
        return input.replace(" ", "");
    }

    public boolean nullCheck(String input) {
        return input == null || input.isBlank();
    }

    public String[] splitString(String input) {
        Matcher m = Pattern.compile(CUSTOM_SEPARATOR).matcher(input);
        if (m.find()) {
            return m.group(INPUT_GROUP_NUM).split(m.group(PATTERN_GROUP_NUM));
        }
        return input.split(DEFAULT_SEPARATOR);
    }
}
