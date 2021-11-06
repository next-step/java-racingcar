package calculator.domain;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

    private static final StringCalculator CALCULATOR = new StringCalculator();

    private StringCalculator() {
    }

    public static StringCalculator getInstance() {
        return CALCULATOR;
    }

    public Operand execute(String expression) {
        return calculate(Expression.verify(expression));
    }

    private Operand calculate(String expression) {
        String[] tokens = expression.split(" ");

        List<Operator> operators = getOperators(tokens);
        List<Operand> operands = getOperands(tokens);

        Iterator<Operand> operandIterator = operands.iterator();
        Iterator<Operator> operatorIterator = operators.iterator();

        Operand left = operandIterator.next();

        while (operandIterator.hasNext()) {
            Operand right = operandIterator.next();
            left = new Expression(left, right, operatorIterator.next()).calculate();
        }

        return left;
    }

    private List<Operand> getOperands(String[] tokens) {
        return Arrays.stream(tokens)
                .filter(token -> !Operator.isOperator(token))
                .map(Operand::of)
                .collect(Collectors.toList());

    }

    private List<Operator> getOperators(String[] tokens) {
        return Arrays.stream(tokens)
                .filter(Operator::isOperator)
                .map(Operator::of)
                .collect(Collectors.toList());
    }
}
