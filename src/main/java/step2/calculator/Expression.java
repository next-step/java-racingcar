package step2.calculator;

import step2.util.validator.ExpressionSymbolValidator;

import java.util.Objects;

import static step2.util.Preconditions.checkArgument;

public class Expression {
    private final String value;
    private static final String BLANK = "";

    public Expression(final String expression) {
        validateExpression(expression);
        this.value = expression;
    }

    public String getValue() {
        return value;
    }

    private void validateExpression(final String expression) {
        checkArgument(Objects.nonNull(expression), "Expression's value should not be null");
        checkArgument(isNotBlank(expression), "Expression's value should not be blank");
        checkArgument(ExpressionSymbolValidator.isValid(expression), "Expression's value should be consist of number and operations");
    }
    
    private boolean isNotBlank(final String expression) {
        return !BLANK.equals(expression);
    }
}
