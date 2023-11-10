package study.calculator;

import java.util.regex.Pattern;

public class Splitter {

    private final String DEFAULT_SPLITTER = "[,:]";
    private final String CUSTOM_SPLITTER_PATTERN = "//(.)\n(.*)";
    private final int CUSTOM_EXPRESSION_START_POSITION = 4;
    private final int CUSTOM_SPLITTER_POSITION = 2;
    private ExceptionHandler exceptionHandler;
    private Pattern customSplitterPattern;

    public Splitter() {
        exceptionHandler = new ExceptionHandler();
        customSplitterPattern = Pattern.compile(CUSTOM_SPLITTER_PATTERN);
    }

    public int[] getNumbers(String inputString) {
        String[] stringNumbers = getStringNumbers(inputString);

        int[] intNumbers = new int[stringNumbers.length];
        for (int i = 0; i < stringNumbers.length; i++) {
            int number = parseToInt(stringNumbers[i]);
            this.exceptionHandler.checkNegativeNumber(number);
            intNumbers[i] = number;
        }

        return intNumbers;
    }

    private String[] getStringNumbers(String inputString) {
        if (isCustomSplitter(inputString)) {
            return splitByCustomSplitter(inputString);
        }
        return splitByGeneralSplitter(inputString);
    }

    private boolean isCustomSplitter(String text) {
        if (customSplitterPattern.matcher(text).find()) {
            return true;
        }
        return false;
    }

    private String[] splitByCustomSplitter(String inputString) {
        char customSplitter = inputString.charAt(CUSTOM_SPLITTER_POSITION);
        return getExpression(inputString).split(String.valueOf(customSplitter));
    }

    private String getExpression(String expression) {
        return expression.substring(CUSTOM_EXPRESSION_START_POSITION);
    }

    private String[] splitByGeneralSplitter(String inputString) {
        return inputString.split(DEFAULT_SPLITTER);
    }

    private int parseToInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 이외의 값을 int로 변경할 수 없습니다.");
        }
    }
}
