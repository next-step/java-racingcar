package study.step2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Expression {

    private final List<Integer> numbers;
    private final List<Operator> operators;

    public Expression(List<Integer> numbers, List<Operator> operators) {
        this.numbers = numbers;
        this.operators = operators;
    }

    public void addNumber(int number) {
        numbers.add(number);
    }

    public void addOperator(Operator operator) {
        operators.add(operator);
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public LinkedList<Operator> getOperator() {
        return new LinkedList<>(operators);
    }
}
