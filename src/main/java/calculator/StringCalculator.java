package calculator;

import java.util.function.IntBinaryOperator;

public class StringCalculator {

    public StringCalculator() {

    }

    public int calculate(int num, Operator operator, int num2) {
        return operator.calculator(num, num2);
    }

    enum Operator {
        PLUS('+', (num, num2) -> num + num2),
        MINUS('-', (num, num2) -> num - num2),
        MULTIPLY('*', (num, num2) -> num * num2),
        DIVIDE('/', (num, num2) -> {
            validateDivision(num2);
            return num / num2;
        });

        private final char symbol;
        private final IntBinaryOperator expression;

        Operator(char symbol, IntBinaryOperator expression) {
            this.symbol = symbol;
            this.expression = expression;
        }

        public int calculator(int num, int num2) {
            return expression.applyAsInt(num, num2);
        }

        private static void validateDivision(int number) {
            if (number == 0) {
                throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
            }
        }
    }
}
