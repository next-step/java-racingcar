package calculator.domain;

import java.util.List;

public class Calculator {

    public double doMultipleOperation(List<Integer> numbers, List<Operator> operators) {
        double result = numbers.remove(0);
        int numberSize = numbers.size();
        for (int i = 0; i < numberSize; i++) {
            result = operators.get(i).operate(result, numbers.get(i));
        }
        return result;
    }
}
