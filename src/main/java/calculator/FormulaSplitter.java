package calculator;

import java.util.Objects;

public class FormulaSplitter {
    private static final String DELIMITER = " ";
    private static final String EMPTY_STRING = "";

    private FormulaSplitter() {
    }

    public static String[] split(String input) {
        inputValidate(input);
        return input.split(DELIMITER);
    }

    private static void inputValidate(String input) {
        if (Objects.isNull(input) || EMPTY_STRING.equals(input)) {
            throw new IllegalArgumentException("입력값이 올바르지 않습니다.");
        }
    }
}
