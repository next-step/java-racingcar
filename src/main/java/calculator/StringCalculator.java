package calculator;

import calculator.operator.Operator;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import calculator.number.PositiveInt;

public class StringCalculator {

    private static final String SEPARATORS = "[,:]";
    private static final String CUSTOM_SEPARATOR_PATTERN = "//(.)\n(.*)";

    public static int splitAndCalculate(String input, String operator) {
        if (Objects.isNull(input) || input.isEmpty()) {
            return 0;
        }

        return calculate(split(input), Operator.findBySign(operator));
    }

    private static String[] split(String input) {
        if (isUsedCustomSeparator(input)) {
            return splitWithCustomSeparator(input);
        }

        return input.split(SEPARATORS);
    }

    private static boolean isUsedCustomSeparator(String input) {
        return Pattern.matches(CUSTOM_SEPARATOR_PATTERN, input);
    }

    private static String[] splitWithCustomSeparator(String input) {
        Matcher matcher = Pattern.compile(CUSTOM_SEPARATOR_PATTERN).matcher(input);

        if (!matcher.find()) {
            throw new RuntimeException("허용하지 않는 값이 존재합니다.");
        }

        String customSeparator = matcher.group(1);
        return matcher.group(2).split(customSeparator);
    }

    private static int calculate(String[] splited, Operator operator) {
        int result = 0;
        for (String token : splited) {
            result = operator.execute(result, PositiveInt.fromString(token).value());
        }

        return result;
    }
}
