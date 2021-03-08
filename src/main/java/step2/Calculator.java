package step2;

import java.util.function.BiFunction;

public class Calculator {
    private int number1;

    public Calculator(int number) {
        this.number1 = number;
    }

    public int calculate(String operator, int number2) {
        return Calculation.findCalculationMethod(operator).calculate(number1, number2);
    }

    public enum Calculation {

        ADDITION("+", (number1, number2) -> number1 + number2),
        SUBTRACTION("-", (number1, number2) -> number1 - number2),
        MULTIPLICATION("*", (number1, number2) -> number1 * number2),
        DIVISION("/", (number1, number2) -> number1 / number2),
        ;

        private String operator;
        private BiFunction<Integer, Integer, Integer> calculationMethod;

        Calculation(String operator, BiFunction<Integer, Integer, Integer> calculationMethod) {
            this.operator = operator;
            this.calculationMethod = calculationMethod;
        }

        private int calculate(int number1, int number2) {
            return findCalculationMethod(operator).calculationMethod.apply(number1, number2);
        }

        private static Calculation findCalculationMethod(String operator) {
            for (Calculation calculation : Calculation.values()) {
                if (calculation.operator.equals(operator)) {
                    return calculation;
                }
            }
            throw new IllegalArgumentException();
        }
    }

}
