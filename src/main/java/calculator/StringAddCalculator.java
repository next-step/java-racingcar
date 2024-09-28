package calculator;

import calculator.exception.StringAddException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Character.*;


public class StringAddCalculator {

    public static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    public static final String DEFAULT_DELIMITER = ",|:";
    public static final Pattern pattern = Pattern.compile(CUSTOM_DELIMITER);

    private StringAddCalculator() {

    }

    public static int splitAndSum(String expression) {

        if (isBlank(expression)) {
            return 0;
        }

        return addNumber(splitNumbers(expression));
    }

    private static boolean isBlank(String expression) {
        return expression == null || expression.isEmpty();
    }

    private static String[] splitNumbers(String expression) {
        Matcher m = pattern.matcher(expression);

        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return expression.split(DEFAULT_DELIMITER);
    }

    private static int addNumber(String[] numbers) {
        int result = 0;
        for (String number : numbers) {
            isValidNumber(number);
            result += Integer.parseInt(number);
        }
        return result;
    }

    private static void isValidNumber(String number) {
        if (!isPositiveNumber(number)) {
            throw new StringAddException("숫자 이외의 값 또는 음수를 입력하였습니다.");
        }
    }

    private static boolean isPositiveNumber(String number) {
        for (char c : number.toCharArray()) {
            if (!isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
