package calculator;

import java.util.regex.Pattern;

public class StringCalculator {

    public static final String DELIMITER = "\\s";
    public static final String REGEX_PATTERN = "^(\\d+)(?:\\s+[\\+\\-\\*\\/]+\\s+(\\d+))*$";
    private int result;

    String[] toStringArrays(String input) {
        validateBlank(input);
        validateDelimiters(input);
        return input.split(DELIMITER);
    }

    private void validateDelimiters(String checkString) {
        checkString = checkString.trim();
        Pattern pattern = Pattern.compile(REGEX_PATTERN);
        if (!pattern.matcher(checkString).find()) {
            throw new IllegalArgumentException("구분자는 공백을 사용합니다.");
        }
    }

    public int calculate(String input) {
        String[] stringArray = toStringArrays(input);
        result = parseInt(stringArray[0]);
        for (int index = 1; index < stringArray.length; index += 2) {
            operator(Operator.from(stringArray[index]), stringArray[index + 1]);
        }
        return result;
    }

    private void validateBlank(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("문자열을 입력하세요. ex) 4 + 2 / 3 ..");
        }
    }

    private void operator(Operator operator, String num) {
        result = operator.calculator(result, parseInt(num));
    }

    private int parseInt(String num) {
        return Integer.parseInt(num);
    }

}
