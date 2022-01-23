package strcalculator.domain;

import java.util.List;

public class Calculator {
    private List<String> inputStr;
    public Calculator() {
    }

    public Calculator(List<String> inputStr) {
        this.inputStr=inputStr;
    }

    public void calculate() {
        int total = Integer.valueOf(inputStr.get(0));
        for (int i = 1; i < inputStr.size(); i += 2) {
            String operator = inputStr.get(i);
            if (operator.equals("+")) {
                total = add(total, Integer.valueOf(inputStr.get(i + 1)));
            } else if (operator.equals("-")) {
                total = subtract(total, Integer.valueOf(inputStr.get(i + 1)));
            } else if (operator.equals("*")) {
                total = multiply(total, Integer.valueOf(inputStr.get(i + 1)));
            } else if (operator.equals("/")) {
                total = divide(total, Integer.valueOf(inputStr.get(i + 1)));
            }
        }
        System.out.println(total);
    }

    public int add(int number1, int number2) {
        return number1 + number2;
    }

    public int subtract(int number1, int number2) {
        return number1 - number2;
    }

    public int multiply(int number1, int number2) {
        return number1 * number2;
    }

    public int divide(int number1, int number2) {
        return number1 / number2;
    }
}
