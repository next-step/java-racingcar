package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private List<String> operators = new ArrayList<>();
    private List<Double> numbers = new ArrayList<>();

    public Calculator(InputArray inputArray) {
        this.operators = inputArray.getOperators();
        this.numbers = inputArray.getNumbers();
    }

    public double calculateAll() {
        double prev = numbers.get(0);
        for (int i = 0; i < operators.size(); i++) {
            prev = calculateOnePart(prev, i);
        }
        return prev;
    }

    public double calculateOnePart(double prev, int indexOfOperator) {
        String operator = operators.get(indexOfOperator);
        double next = numbers.get(indexOfOperator + 1);

        if ("+".equals(operator)) {
            return prev + next;
        }
        if ("-".equals(operator)) {
            return prev - next;
        }
        if ("*".equals(operator)) {
            return prev * next;
        }
        return prev / next;
    }
}
