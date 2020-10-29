package stringcalculator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ArithmeticExpression {
    private static final String DELIMITER = " ";

    private final List<Integer> numbers;
    private final List<Operator> operators;

    ArithmeticExpression(String input) {
        numbers = new ArrayList<>();
        operators = new ArrayList<>();

        String[] inputSplits = input.split(DELIMITER);

        for (int i = 0; i < inputSplits.length; i++) {
            addArithmeticNode(inputSplits[i], i);
        }
    }

    void addArithmeticNode(String inputSplit, int index) {
        if (isNumberIndex(index)) {
            numbers.add(Integer.valueOf(inputSplit));
            return;
        }

        if (isOperatorIndex(index)) {
            operators.add(Operator.findBy(inputSplit));
            return;
        }

        throw new IllegalArgumentException("Invalid index. " + index);
    }

    private boolean isNumberIndex(int index) {
        return index % 2 == 0;
    }

    private boolean isOperatorIndex(int index) {
        return index % 2 != 0;
    }

    Integer evaluate() {
        validateArithmeticNodes();

        Iterator<Integer> numbersIterator = numbers.iterator();
        Iterator<Operator> operatorIterator = operators.iterator();

        Integer result = numbersIterator.next();
        while (numbersIterator.hasNext() && operatorIterator.hasNext()) {
            Integer number = numbersIterator.next();
            Operator operator = operatorIterator.next();
            result = operator.calculate(result, number);
        }
        return result;
    }

    private void validateArithmeticNodes() {
        if (numbers.isEmpty()) {
            throw new IllegalStateException("There are no numbers in the expression.");
        }

        if (numbers.size() != operators.size() + 1) {
            throw new IllegalStateException("Number must be one more than operator.");
        }
    }
}
