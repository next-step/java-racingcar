package step2;

import java.util.Arrays;
import java.util.function.BiFunction;

public class Calculator {

    public int calculate(String formula) {

        checkInput(formula);

        return calculate(formula.split(" "));
    }

    private void checkInput(String formula) {
        if(formula == null || formula.isEmpty()) {
            throw new IllegalArgumentException("input 값이 없습니다.");
        }
    }

    private int calculate(String[] terms) {

        int current = Integer.parseInt(terms[0]); // 왼쪽 항

        for(int i = 1; i < terms.length; i +=2) {
            current = Operator.calculate(terms[i], current, Integer.parseInt(terms[i + 1]));
        }

        return current;
    }

    enum Operator {
        PLUS("+", (a, b) -> a + b),
        SUBTRACT("-", (a, b) -> a - b),
        MULTIPLY("*", (a, b) -> a * b),
        DIVIDE("/", (a, b) -> a / b);

        private String operator;
        private BiFunction<Integer, Integer, Integer> calculation; // BiFunction - 매개변수가 두 개이며 return 값이 있는 함수형 인터페이스

        Operator(String operator, BiFunction<Integer, Integer, Integer> calculation) {
            this.operator = operator;
            this.calculation = calculation;
        }

        public static int calculate(String operator, int a, int b) {
            return getOperator(operator).calculation.apply(a, b);
        }

        private static Operator getOperator(String operator) {
            return Arrays.stream(values())
                    .filter(o -> o.operator.equals(operator))
                    .findFirst().orElseThrow(() -> new IllegalArgumentException("올바른 연산자가 아닙니다."));
        }
    }
}
