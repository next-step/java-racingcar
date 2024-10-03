package study.step_2.domain;

import static study.step_2.constant.error.ErrorMessage.*;
import static study.step_2.domain.DelimConstant.*;

public class Calculator implements Calculate {

    public static final int INVALID_INPUT_VALUE = 0;
    public static final String USING_PREFIX = "//";
    public Character customDelimiter;

    public String expression;

    public Calculator(String expression) {
        if (BlankAndNull(expression)) return;
        extractCustomDelim(expression);
        validExpression(expression);
        this.expression = expression;
    }

    private boolean BlankAndNull(String expression) {
        if (checkBlankAndNull(expression)) {
            this.expression = "0";
            return true;
        }
        return false;
    }

    private boolean checkBlankAndNull(String expression) {
        return expression == null || expression.trim().isEmpty();
    }

    private void extractCustomDelim(String expression) {
        if (expression.startsWith("//")) {
            customDelimiter = expression.substring(2, 3).charAt(0);
            validCustomDelimiterDigit(customDelimiter);
        }
    }

    private void validCustomDelimiterDigit(char c) {
        if ((Character.isDigit(c))) {
            throw new RuntimeException(INVALID_DELIMITER_TYPE.getMessage());
        }
    }

    private void validExpression(String expression) {
        validNegativeAndDelimiter(expression);
    }

    private void validNegativeAndDelimiter(String expression) {

        if (startWithCustomDelimiter(expression)) {
            validateInvalidCharacterWithCustomDelimiter(expression);
        } else {
            validateInvalidCharacter(expression);
        }
    }

    private void validateInvalidCharacter(String expression) {
        for (Character c : expression.toCharArray()) {
            validateNegativeNumber(c);
            validateInvalidCharacter(c);
        }
    }

    private void validateNegativeNumber(Character c) {
        if (c.equals('-') && customDelimiter != '-') {
            throw new RuntimeException(INVALID_NEGATIVE_NUMBER.getMessage());
        }
    }

    public boolean startWithCustomDelimiter(String expression) {
        return expression.startsWith(USING_PREFIX);
    }

    private void validateInvalidCharacter(Character c) {
        if (c != DELIMITER_COMMA.getValue() && c != DELIMITER_COLON.getValue()
                && !Character.isDigit(c)) {
            throw new RuntimeException(INVALID_NUMBER_TYPE.getMessage());
        }
    }

    private void validateInvalidCharacterWithCustomDelimiter(String expression) {
        for(int i = 4; i < expression.length(); i++) {
            char c = expression.charAt(i);
            validateNumberType(c);
            validateNegative(c);
        }
    }

    private void validateNegative(char c) {
        if (c == ('-') && customDelimiter != '-') {
            throw new RuntimeException(INVALID_NEGATIVE_NUMBER.getMessage());
        }
    }

    private void validateNumberType(char c) {
        if (c != customDelimiter && !Character.isDigit(c) && c != '\n') {
            throw new RuntimeException(INVALID_NUMBER_TYPE.getMessage());
        }
    }

    @Override
    public int splitAndSum(String express) {
        int sumValue = 0;

        if (expression.equals("0")) {
            return 0;
        }

        if (customDelimiterUsing(customDelimiter)) {
            return executeWithCustomDelimiter(express);
        }

        int i = executeWithDefaultDelimiter(express);
        return (i >= 0) ? i : sumValue;
    }

    private int executeWithDefaultDelimiter(String express) {
        int sumValue = 0;

        for (int i = 0; i < express.length(); i++) {
            sumValue += getValue(express, i);
        }
        return sumValue;
    }

    private static int getValue(String express, int i) {
        if (express.charAt(i) != DELIMITER_COMMA.getValue() && express.charAt(i) != DELIMITER_COLON.getValue()) {
            return Integer.parseInt(String.valueOf(express.charAt(i)));
        }
        return 0;
    }

    private boolean customDelimiterUsing(Character customDelimiter) {
        return customDelimiter != null;
    }

    private int executeWithCustomDelimiter(String express) {
        int sumValue = 0;

        for (int i = 4; i < express.length(); i++) {
            sumValue = getSumValue(express, i, sumValue);
        }
        return sumValue;
    }

    private int getSumValue(String express, int i, int sumValue) {
        if (express.charAt(i) != DELIMITER_COMMA.getValue() && express.charAt(i) != DELIMITER_COLON.getValue() && express.charAt(i) != customDelimiter) {
            sumValue += Integer.parseInt(String.valueOf(express.charAt(i)));
        }
        return sumValue;
    }
}
