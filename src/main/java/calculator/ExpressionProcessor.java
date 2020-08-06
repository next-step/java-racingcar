package calculator;

import java.util.Arrays;
import java.util.Objects;

public class ExpressionProcessor {

    private String[] arguments;

    public ExpressionProcessor(String expression) {
        this.arguments = splitExpression(expression);
    }

    // 테스트를 위하여 접근 지정자를 public으로 설정
    public static String[] splitExpression(String expression) {
        if (Objects.isNull(expression) || expression.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.EMPTY_OR_NULL_ARGUMENT.getMessage());
        }
        return expression.split(" ");
    }

    public int[] getNumbers() {
        return Arrays.stream(this.arguments)
                .filter(ExpressionProcessor::isNumber)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public Operator[] getOperators() {
        return Arrays.stream(this.arguments)
                .filter(a -> !ExpressionProcessor.isNumber(a))
                .map(Operator::of)
                .toArray(Operator[]::new);
    }

    private static boolean isNumber(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
