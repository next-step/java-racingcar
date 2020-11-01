package step2.calculator.domain;

import common.util.Message;
import step2.calculator.util.ExpressionSeparator;
import step2.calculator.validator.ExpressionSymbolValidator;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static common.util.Preconditions.checkArgument;

public class Expression {
    private static final String BLANK = "";

    public enum ErrorMessage implements Message {
        NOT_BE_NULL(Expression.class.getName() + "'s value should not be null"),
        NOT_BE_BLANK(Expression.class.getName() + "'s value should not be blank"),
        CONSIST_OF_NUMBER_AND_OPERATIONS(Expression.class.getName() + "'s value should be consist of number and operations"),
        ;

        private final String message;

        public String getMessage() {
            return message;
        }

        ErrorMessage(String message) {
            this.message = message;
        }
    }

    private final List<String> symbols;

    public Expression(final String expression) {
        validateExpression(expression);
        this.symbols = Collections.unmodifiableList(ExpressionSeparator.split(expression));
    }

    public List<String> getSymbols() {
        return symbols;
    }

    private void validateExpression(final String expression) {
        checkArgument(Objects.nonNull(expression), ErrorMessage.NOT_BE_NULL);
        checkArgument(isNotBlank(expression), ErrorMessage.NOT_BE_BLANK);
        checkArgument(ExpressionSymbolValidator.isValid(expression), ErrorMessage.CONSIST_OF_NUMBER_AND_OPERATIONS);
    }

    private boolean isNotBlank(final String expression) {
        return !BLANK.equals(expression);
    }
}
