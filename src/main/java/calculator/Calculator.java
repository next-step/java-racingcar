package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    public static final String PLUS = "+";
    public static final String MINUS = "-";
    public static final String TIMES = "*";
    public static final String DIVIDED_BY = "/";
    private static final int INCREMENT_FOR_NEXT_NUMBER = 1;

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
        double next = numbers.get(indexOfOperator + INCREMENT_FOR_NEXT_NUMBER);

        if (PLUS.equals(operator)) {
            return prev + next;
        }
        if (MINUS.equals(operator)) {
            return prev - next;
        }
        if (TIMES.equals(operator)) {
            return prev * next;
        }
        return prev / next;
    }
}
