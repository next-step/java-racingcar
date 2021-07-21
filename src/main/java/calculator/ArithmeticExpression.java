package calculator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArithmeticExpression {

    private static final String INPUT_VALIDATION_EXCEPTION_MESSAGE_FORMAT = "입력 값이 유효하지 않습니다. %s";
    private static final String EXPRESSION_DELIMITER = " ";
    private static final int ONLY_ONE_OPERATOR_EXPRESSION_LENGTH = 3;
    private static final int FIRST_NUMBER_INDEX = 0;
    public static final int EXPRESSION_START_INDEX = 0;

    private final List<String> expressions;

    private ArithmeticExpression(List<String> expressions) {
        this.expressions = Collections.unmodifiableList(expressions);
    }

    public static ArithmeticExpression of(String input) {
        validate(input);
        return new ArithmeticExpression(Arrays.asList(input.split(EXPRESSION_DELIMITER)));
    }

    private static void validate(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(String.format(INPUT_VALIDATION_EXCEPTION_MESSAGE_FORMAT, input));
        }
    }

    public boolean hasOnlyOneOperator() {
        return this.expressions.size() == ONLY_ONE_OPERATOR_EXPRESSION_LENGTH;
    }

    public int getFirstNumber() {
        return Integer.parseInt(this.expressions.get(FIRST_NUMBER_INDEX));
    }

    public int getLastNumber() {
        return Integer.parseInt(this.expressions.get(this.expressions.size() - 1));
    }

    public Operator getLastOperator() {
        return Operator.of(this.expressions.get(this.expressions.size() - 2));
    }

    public ArithmeticExpression exceptLastOperation() {
        return new ArithmeticExpression(this.expressions.subList(EXPRESSION_START_INDEX, this.expressions.size() - 2));
    }
}
