package Calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private final Pattern pattern = Pattern.compile("//(.)\n(.*)");
    private final String separator = ",|:";
    private final String errorMessageNegativeNumber = "음수를 입력할 수 없습니다.";
    private final String errorMessageNotNumber = "숫자만 입력할 수 있습니다.";

    public int add(String input) {
        if (checkNullOrEmpty(input)) {
            return 0;
        }
        String[] numbers = splitNumber(input);
        int sum = sumNumbers(numbers);

        return sum;
    }

    private int sumNumbers(String[] numbers) {
        int result = 0;
        for (String number : numbers) {
            result += checkPositiveNumber(number);
        }

        return result;
    }

    private int checkPositiveNumber(String number) {
        int result = ConvertToInteger(number);
        if (result < 0) {
            throw new RuntimeException(errorMessageNegativeNumber);
        }

        return result;
    }

    private int ConvertToInteger(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException ex) {
            throw new RuntimeException(errorMessageNotNumber);
        }
    }

    private String[] splitNumber(String input) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }

        return input.split(separator);
    }

    private boolean checkNullOrEmpty(String input) {
        if (input == null) {
            return true;
        }
        if (input.trim().isEmpty()) {
            return true;
        }

        return false;
    }
}
