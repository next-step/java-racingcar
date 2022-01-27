package calculator.domain;

public class Calculator {

    private Calculator() {}

    public static double evaluate(Terms terms, Operators operators) {
        double acc = terms.nextTerm();

        while (operators.hasNext()) {
            acc = operators.nextOperator().operate(acc, terms.nextTerm());
        }

        return acc;
    }
}
