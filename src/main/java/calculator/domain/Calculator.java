package calculator.domain;

import java.util.List;

public class Calculator {

    public Calculator() {
    }

    public void calculate(List<String> parsedInput) {
        int total = Integer.parseInt(parsedInput.get(0));
        int inputSize = parsedInput.size();
        for (int i = 1; i < inputSize; i += 2) {
            String operator = parsedInput.get(i);
            int nextNumber = Integer.parseInt(parsedInput.get(i+1));
            total = operate(operator, total, nextNumber);
        }
        System.out.println(total);
    }

    private int operate(String operator, int prevNumber, int nextNumber) {
        return Operator.getType(operator).operate(prevNumber, nextNumber);
    }
}
