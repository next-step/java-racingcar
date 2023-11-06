package study.stringCalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {

    private final String DEFAULT_SPLITTER = "[,:]";
    private final String CUSTOM_SPLITTER_PATTERN = "//(.)\n(.*)";
    private final int CUSTOM_EXPRESSION_START_POSITION = 4;
    private final int CUSTOM_SPLITTER_POSITION = 2;
    private ExceptionHandler exceptionHandler;

    public Splitter() {
        exceptionHandler = new ExceptionHandler();
    }

    private boolean isCustomSplitter(String text) {
        Matcher m = Pattern.compile(CUSTOM_SPLITTER_PATTERN).matcher(text);
        if (m.find()) {
            return true;
        }
        return false;
    }

    private String getExpression(String expression) {
        return expression.substring(CUSTOM_EXPRESSION_START_POSITION);
    }

    private int parseToInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 이외의 값을 int로 변경할 수 없습니다.");
        }
    }

    private String[] getStringNumbers(String input_string) {
        String[] stringNumbers;
        if (isCustomSplitter(input_string)) {
            stringNumbers = splitByCustomSplitter(input_string);
        } else {
            stringNumbers = splitByGeneralSplitter(input_string);
        }
        return stringNumbers;
    }

    // 커스텀 스플릿
    private String[] splitByCustomSplitter(String input_string) {
        char customSplitter = input_string.charAt(CUSTOM_SPLITTER_POSITION);
        return getExpression(input_string).split(String.valueOf(customSplitter));
    }

    // 제네럴 스플릿
    private String[] splitByGeneralSplitter(String input_string) {
        return input_string.split(DEFAULT_SPLITTER);
    }

    public int[] getNumbers(String input_string) {
        String[] stringNumbers = getStringNumbers(input_string);

        int[] intNumbers = new int[stringNumbers.length];
        for (int i = 0; i < stringNumbers.length; i++) {
            int number = parseToInt(stringNumbers[i]);
            this.exceptionHandler.checkNegativeNumber(number);
            intNumbers[i] = number;
        }

        return intNumbers;
    }
}
