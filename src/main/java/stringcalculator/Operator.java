package stringcalculator;

import java.util.function.BiFunction;

enum Operator {
    PLUS("+", (num1, num2) -> num1 + num2),
    MINUS("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> num1 / num2);

    private final String strValue;
    private final BiFunction<Integer, Integer, Integer> calculate;

    Operator(String strValue, BiFunction<Integer, Integer, Integer> calculate) {
        this.strValue = strValue;
        this.calculate = calculate;
    }
}
