package step2.calculator;

import step2.calculator.exceptions.InvalidExpressionException;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;

public enum Expression {
    PLUS("+", (ex) -> ex.frontNumber + ex.backNumber),
    MINUS("-", (ex) -> ex.frontNumber - ex.backNumber),
    MULTIPLY("*", (ex) -> ex.frontNumber * ex.backNumber),
    DIVIDE("/", (ex) -> ex.frontNumber / ex.backNumber);

    private String label;
    private Function<ExpressionWith, Integer> calculate;

    Expression(String label, Function<ExpressionWith, Integer> calculate) {
        this.label = label;
        this.calculate = calculate;
    }

    static public Expression of(String label) {
        return Arrays.stream(values())
                .filter(expression -> expression.label.equals(label))
                .findFirst()
                .orElseThrow(InvalidExpressionException::new);
    }

    public int calculate(ExpressionWith expression) {
        return calculate.apply(expression);
    }

}
