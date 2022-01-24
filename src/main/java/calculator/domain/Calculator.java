package calculator.domain;

public class Calculator {

    private static final String ADD = "+";
    private static final String SUBTRACT = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";
    private static final int INDIVISIBLE_NUMBER = 0;


    private Calculator() {}

    public static double evaluate(Terms terms, Operators operators) {

        double acc = terms.nextTerm();

        while (operators.hasNext()) {
            acc = calculate(acc, terms.nextTerm(), operators.nextOperator());
        }

        return acc;
    }

    private static double calculate(double acc, double term, String op) {
        switch (op) {
            case ADD:
                return add(acc, term);
            case SUBTRACT:
                return subtract(acc, term);
            case MULTIPLY:
                return multiply(acc, term);
            case DIVIDE:
                return divide(acc, term);
            default:
                throw new ArithmeticException("[ERROR]지원하지 않는 연산자 입니다.");
        }
    }

    private static double add(double num1, double num2) {
        return num1 + num2;
    }

    private static double subtract(double num1, double num2) {
        return num1 - num2;
    }

    private static double multiply(double num1, double num2) {
        return num1 * num2;
    }

    private static double divide(double num1, double num2) {
        if (num2 == INDIVISIBLE_NUMBER) {
            throw new ArithmeticException("[ERROR] 0으로 나눌 수 없습니다.");
        }
        return num1 / num2;
    }
}
