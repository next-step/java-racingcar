package stringcalculator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StringCalculator {
    private static final String DELIMITER = " ";

    public Integer calculate(String input) {
        validateInput(input);

        List<Integer> numbers = new ArrayList<>();
        List<Operator> operators = new ArrayList<>();
        initArithmeticLists(input, numbers, operators);

        Iterator<Integer> numberIterator = numbers.iterator();
        Iterator<Operator> operatorIterator = operators.iterator();
        Integer result = numberIterator.next();
        while (numberIterator.hasNext() && operatorIterator.hasNext()) {
            Integer nextNumber = numberIterator.next();
            Operator nextOperator = operatorIterator.next();
            result = nextOperator.calculate(result, nextNumber);
        }
        return result;
    }

    private void validateInput(String input) {
        if (input == null || input.equals("")) {
            throw new IllegalArgumentException("Input can not be null or empty.");
        }
    }

    private void initArithmeticLists(String input, List<Integer> numbers, List<Operator> operators) {
        String[] inputSplits = input.split(DELIMITER);
        for (int i = 0; i < inputSplits.length; i++) {
            if (isNumberIndex(i)) {
                numbers.add(Integer.valueOf(inputSplits[i]));
                continue;
            }

            if (isOperatorIndex(i)) {
                operators.add(Operator.findBy(inputSplits[i]));
            }
        }
    }

    private boolean isNumberIndex(int i) {
        return i % 2 == 0;
    }

    private boolean isOperatorIndex(int i) {
        return i % 2 != 0;
    }
}
