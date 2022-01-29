package stringCalculator;

import java.util.List;

public class Calculator {

    public int calculateByOperator(List<String> userInput) {
        int result = Integer.parseInt(userInput.get(0));
        int userInputSize = userInput.size();
        for (int i = 1; i < userInputSize - 1; i += 2) {
            if (userInput.get(i).equals("+")) {
                result = sum(result, Integer.parseInt(userInput.get(i + 1)));
                continue;
            }
            if (userInput.get(i).equals("-")) {
                result = subtract(result, Integer.parseInt(userInput.get(i + 1)));
                continue;
            }
            if (userInput.get(i).equals("*")) {
                result = multiply(result, Integer.parseInt(userInput.get(i + 1)));
                continue;
            }
            if (userInput.get(i).equals("/")) {
                result = divide(result, Integer.parseInt(userInput.get(i + 1)));
                continue;
            }
            throw new IllegalArgumentException("사칙 연산이 아닙니다");
        }
        return result;
    }

    private int sum(int a, int b) {
        return a + b;
    }

    private int subtract(int a, int b) {
        return a - b;
    }

    private int multiply(int a, int b) {
        return a * b;
    }

    private int divide(int a, int b) {
        return a / b;
    }
}
