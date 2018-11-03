package calculator;

import java.util.function.BiFunction;
import java.util.stream.Stream;

public class Calculator {

    private Calculator() {

    }

    public static int calculate(String operator, int leftSide, int rightSide) {
        return Operator.apply(operator, leftSide, rightSide);
    }

    public static int add(int leftSide, int rightSide) {
        return leftSide + rightSide;
    }

    public static int subtract(int leftSide, int rightSide) {
        return leftSide - rightSide;
    }

    public static int multiple(int leftSide, int rightSide) {
        return leftSide * rightSide;
    }

    public static int divide(int leftSide, int rightSide) {
        return leftSide / rightSide;
    }

    enum Operator {
        ADD         ("+", (leftSide, rightSide) -> Calculator.add(leftSide, rightSide)),
        SUBTRACT    ("-", (leftSide, rightSide) -> Calculator.subtract(leftSide, rightSide)),
        MULTIPLE    ("*", (leftSide, rightSide) -> Calculator.multiple(leftSide, rightSide)),
        DIVIDE      ("/", (leftSide, rightSide) -> Calculator.divide(leftSide, rightSide));

        private String operator;
        private BiFunction<Integer, Integer, Integer> formula;

        Operator(String operators, BiFunction<Integer, Integer, Integer> formula) {
            this.operator = operators;
            this.formula = formula;
        }

        public static int apply(String operator, int leftSide, int rightSide) {
            return findByOperatorName(operator).formula.apply(leftSide, rightSide);
        }

        private static Operator findByOperatorName(String operatorName) {
            return Stream.of(Operator.values())
                    .filter(o -> o.operator.equals(operatorName))
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
        }
    }
}