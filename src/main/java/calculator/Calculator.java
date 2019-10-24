package calculator;

import java.util.Objects;

public class Calculator {
    private static final String INPUT_IS_NULL_EXCEPTION_MESSAGE = "Input이 Null 입니다.";
    private static final String INPUT_IS_EMPTY_EXCEPTION_MESSAGE = "Input이 공백 입니다.";
    private static final String CAN_NOT_CALCULATE_STRING_FORMAT = "계산 할 수 없는 문자열 입니다.";

    public long calculate(String input) {
        checkInput(input);
        checkInputFormat(input);

        return 0;
    }

    private void checkInput(String input) {
        if (Objects.isNull(input)) {
            throw new IllegalArgumentException(INPUT_IS_NULL_EXCEPTION_MESSAGE);
        }

        if (input.trim().length() == 0) {
            throw new IllegalArgumentException(INPUT_IS_EMPTY_EXCEPTION_MESSAGE);
        }
    }

    private void checkInputFormat(String input) {
        String[] strings = input.split(" ");
        for (int i = 0; i < strings.length; i++) {
            checkFormat(i, strings[i]);
        }
    }

    private void checkFormat(int index, String string) {
        if (isEven(index)) {
            checkNumberFormat(string);
            return;
        }
        checkOperator(string);
    }

    private boolean isEven(int i) {
        return i % 2 == 0;
    }

    private void checkNumberFormat(String string) {
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(CAN_NOT_CALCULATE_STRING_FORMAT);
        }

    }

    private void checkOperator(String string) {
        if (!isSupportOperator(string)) {
            throw new IllegalArgumentException(CAN_NOT_CALCULATE_STRING_FORMAT);
        }
    }

    private boolean isSupportOperator(String string) {
        return "-+*/".contains(string);
    }
}
