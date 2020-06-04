package stringcalculator;

import java.util.Arrays;
import java.util.regex.Pattern;

public class StringExpression {
    private static final Pattern ELEMENT_REGEX = Pattern.compile("^(\\d+|\\+|-|\\*|\\/)$");
    static final String INPUT_NULL_EXCEPTION_MESSAGE = "Expression cannot be null.";
    static final String INPUT_EMPTY_OR_WHITESPACE_ONLY_EXCEPTION_MESSAGE = "Expression cannot be empty, or whitespace-only string.";
    private final String[] elements;
    private int result;
    private boolean calculated = false;

    StringExpression(String expression) {
        checkStringNullOrEmpty(expression);
        String[] elements = expression.trim().split(" ");
        checkElementsAreValid(elements);
        this.elements = elements;
    }

    public int getResult() {
        if (!calculated) {
            this.calculate();
        }
        return result;
    }

    private void checkStringNullOrEmpty(String expression) {
        if (expression == null) {
            throw new IllegalArgumentException(INPUT_NULL_EXCEPTION_MESSAGE);
        }
        String trimmed = expression.trim();
        if (trimmed.isEmpty()) {
            throw new IllegalArgumentException(INPUT_EMPTY_OR_WHITESPACE_ONLY_EXCEPTION_MESSAGE + "'" + expression + "'");
        }
    }

    private void checkElementsAreValid(String[] elements) {
        if (!Arrays.stream(elements).allMatch(e -> ELEMENT_REGEX.matcher(e).matches())) {
            throw new IllegalArgumentException("Expression are not valid elements.");
        }
    }

    private void calculate() {
        boolean isNextOperator = false;
        Operator currentOperator = Operator.ADDITION;

        for (String element : elements) {
            if (isNextOperator) {
                currentOperator = Operator.from(element);
                isNextOperator = false;
                continue;
            }

            int operand = Integer.parseInt(element);
            result = currentOperator.operate(result, operand);
            isNextOperator = true;
        }

        this.calculated = true;
    }

}
