package calculator;


import calculator.exception.ErrorMessage;
import calculator.util.StringUtil;

public class Calculator {

    private static final String DELIMITER = " ";

    public static Calculator of() {
        return new Calculator();
    }

    public Integer run(final String input) {
        if (StringUtil.isEmpty(input)) {
            throw new IllegalArgumentException(ErrorMessage.IS_NULL_OR_EMPTY);
        }

        String[] values = input.split(DELIMITER);
        return this.calculate(values);
    }

    private Integer calculate(final String[] values) {
        return 0;
    }
}
