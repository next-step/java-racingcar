package calculator;

import resource.StringResources;
import util.StringUtils;

import java.util.function.IntBinaryOperator;

public class Calculator {

    private final String equation;
    private final String[] elems;

    public Calculator(String equation) throws IllegalArgumentException {

        this.equation = equation;
        verifyEmptyEquation();

        elems = equation.split(" ");
        verifyElemsLength();
    }

    public int calculate() throws IllegalArgumentException {

        int result = Integer.parseInt(elems[0]);

        for (int i = 1; i < elems.length; i = i + 2) {
            result = calculate(result, elems[i], elems[i + 1]);
        }

        return result;
    }

    private int calculate(int result, String op, String num)
            throws IllegalArgumentException, ArithmeticException {

        Operator operator = Operator.of(op);
        return operator.calculate(result, Integer.parseInt(num));
    }

    private void verifyEmptyEquation() throws IllegalArgumentException {

        if (StringUtils.isBlank(equation)) {
            throw new IllegalArgumentException(StringResources.ERR_INCORRECT_EQUATION);
        }
    }

    private void verifyElemsLength() {

        if (elems.length % 2 == 0) {
            throw new IllegalArgumentException(StringResources.ERR_INCORRECT_EQUATION);
        }
    }

    private enum Operator {

        PLUS((a, b) -> a + b),
        SUBTRACT((a, b) -> a - b),
        MULTIPLY((a, b) -> a * b),
        DIVISION((a, b) -> {
            if (b == 0) {
                throw new ArithmeticException(StringResources.ERR_DIVIDED_BY_ZERO);
            }
            return a / b;
        });

        private final IntBinaryOperator intBinaryOperator;

        Operator(IntBinaryOperator intBinaryOperator) {
            this.intBinaryOperator = intBinaryOperator;
        }

        public static Operator of(String param) throws IllegalArgumentException {

            char op = param.charAt(0);

            switch (op) {
                case '+':
                    return Operator.PLUS;
                case '-':
                    return Operator.SUBTRACT;
                case '*':
                    return Operator.MULTIPLY;
                case '/':
                    return Operator.DIVISION;
            }

            throw new IllegalArgumentException(StringResources.ERR_INCORRECT_OPERATOR);
        }

        public int calculate(int a, int b) throws ArithmeticException {
            return intBinaryOperator.applyAsInt(a, b);
        }
    }
}