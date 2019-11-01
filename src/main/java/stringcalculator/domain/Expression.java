package stringcalculator.domain;

import com.google.common.collect.ImmutableSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Pattern;

public class Expression {

    private static final Pattern NUMBER = Pattern.compile("^[0-9]*$");
    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";
    private static final Set<String> ENABLE_OPERATOR = ImmutableSet.of(PLUS, MINUS, MULTIPLY, DIVIDE);

    private List<Integer> operands;
    private List<String> operators;

    public Expression() {
        this.operands = new ArrayList<>();
        this.operators = new ArrayList<>();
    }

    public void add(String unit) {
        if (NUMBER.matcher(unit).find()) {
            addOperand(Integer.parseInt(unit));
            return;
        }

        addOperator(unit);
    }

    private void addOperator(String unit) {
        if (operands.size() == 0 || operands.size() == operators.size()) {
            throw new IllegalArgumentException();
        }

        if (!ENABLE_OPERATOR.contains(unit)) {
            throw new IllegalArgumentException();
        }

        this.operators.add(unit);
    }

    private void addOperand(int operand) {
        if (operands.size() != operators.size()) {
            throw new IllegalArgumentException();
        }
        this.operands.add(operand);
    }

    public int operate() {
        int result = operands.get(0);
        int operationCount = operators.size();
        for (int i = 0; i < operationCount; i++) {
            final String operator = operators.get(i);
            final int operand = operands.get(i + 1);
            result = operate(result, operator, operand);
        }
        return result;
    }

    private int operate(int operand1, String operator, int operand2) {
        if (operator.equals("+")) {
            return plus(operand1, operand2);
        }

        if (operator.equals("-")) {
            return minus(operand1, operand2);
        }

        if (operator.equals("*")) {
            return multiply(operand1, operand2);
        }

        return divide(operand1, operand2);
    }

    private int plus(int operand1, int operand2) {
        return operand1 + operand2;
    }

    private int minus(int operand1, int operand2) {
        return operand1 - operand2;
    }

    private int multiply(int operand1, int operand2) {
        return operand1 * operand2;
    }

    private int divide(int operand1, int operand2) {
        return operand1 / operand2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expression that = (Expression) o;
        return Objects.equals(operands, that.operands) &&
                Objects.equals(operators, that.operators);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operands, operators);
    }
}
