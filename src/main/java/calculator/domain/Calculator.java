package calculator.domain;

import java.util.List;

public class Calculator {

    public Calculator() {
    }

    public void calculate(List<String> parsedInput) {
        int total = Integer.parseInt(parsedInput.get(0));
        for (int i = 1; i < parsedInput.size(); i += 2) {
            String operator = parsedInput.get(i);
            int nextNumber = Integer.parseInt(parsedInput.get(i+1));
            total = operate(operator, total, nextNumber);
        }
        System.out.println(total);
    }

    private int operate(String operator, int prevNumber, int nextNumber) {
        if ("+".equals(operator)) {
            return add(prevNumber, nextNumber);
        } else if ("-".equals(operator)) {
            return subtract(prevNumber, nextNumber);
        } else if ("*".equals(operator)) {
            return multiply(prevNumber, nextNumber);
        }
        return divide(prevNumber, nextNumber);
    }

    private static int add(int prevNumber, int nextNumber) {
        return prevNumber + nextNumber;
    }

    public int subtract(int prevNumber, int nextNumber) {
        return prevNumber - nextNumber;
    }

    public int multiply(int prevNumber, int nextNumber) {
        return prevNumber * nextNumber;
    }

    public int divide(int prevNumber, int nextNumber) {
        return prevNumber / nextNumber;
    }
}
