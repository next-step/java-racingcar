package calculator;

import java.util.Objects;

public class Calculator {
    private static final String INPUT_IS_NULL_EXCEPTION_MESSAGE = "Input이 Null 입니다.";
    private static final String INPUT_IS_EMPTY_EXCEPTION_MESSAGE = "Input이 공백 입니다.";

    public long calculate(String input) {
        checkInput(input);
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
}
