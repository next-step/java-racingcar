package calculator;

import calculator.exception.DivideByZeroException;
import calculator.exception.InvalidOperatorException;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum StringOperatorEnum {

    ADD("+", (number1, number2) -> number1 + number2),
    SUBTRACT("-", (number1, number2) -> number1 - number2),
    MULTIPLY("*", (number1, number2) -> number1 * number2),
    DIVIDE("/", (number1, number2) -> {
        if (number2 == 0)
            throw new DivideByZeroException();
        return number1 / number2;
    });

    private final String operator;
    private final BinaryOperator<Integer> calculator;

    StringOperatorEnum(String operator, BinaryOperator<Integer> calculator) {
        this.operator = operator;
        this.calculator = calculator;
    }

    public String calculation(int number1, int number2) {
        return Integer.toString(calculator.apply(number1, number2));
    }

    public static StringOperatorEnum of(String inputOperator) {
        return Arrays.stream(values())
                .filter(value -> value.operator.equals(inputOperator))
                .findFirst()
                .orElseThrow(InvalidOperatorException::new);
    }

}
