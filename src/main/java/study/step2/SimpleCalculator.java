package study.step2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static study.step2.Exception.*;

public class SimpleCalculator implements Calculator {

    private final Interpreter interpreter;
    private final List<Integer> numbers;
    private final LinkedList<Operator> operators;

    public SimpleCalculator(Interpreter interpreter) {
        this.interpreter = interpreter;
        this.numbers = new ArrayList<>();
        this.operators = new LinkedList<>();
    }

    @Override
    public int execute(String input) {
        clearAll();
        readExpression(input);
        return numbers.stream()
                .reduce(this::calculate)
                .orElseThrow(() -> new IllegalArgumentException("수식이 올바르지 않습니다"));
    }

    private void readExpression(String input) {
        addAll(interpreter.read(input));
    }

    private void clearAll() {
        numbers.clear();
        operators.clear();
    }

    private void addAll(Expression expression) {
        numbers.addAll(expression.getNumbers());
        operators.addAll(expression.getOperator());
    }

    private int calculate(Integer a, Integer b) {
        OPERATOR_SHORTAGE.validation(operators, OPERATOR_SHORTAGE.getMessage());
        return operators.poll().calculate(a, b);
    }

}
