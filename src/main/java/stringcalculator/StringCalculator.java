package stringcalculator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StringCalculator {
    private static final String DELIMITER = " ";

    public Integer calculator(String input) {
        String[] inputSplits = input.split(DELIMITER);
        List<Integer> numbers = new ArrayList<>();
        List<Operator> operators = new ArrayList<>();

        for (int i = 0; i < inputSplits.length; i++) {
            if (isNumberIndex(i)) {
                numbers.add(Integer.valueOf(inputSplits[i]));
                continue;
            }

            if (isOperatorIndex(i)) {
                operators.add(Operator.findBy(inputSplits[i]));
            }
        }

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

    private boolean isNumberIndex(int i) {
        return i % 2 == 0;
    }

    private boolean isOperatorIndex(int i) {
        return i % 2 != 0;
    }
}
