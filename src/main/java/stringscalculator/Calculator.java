package stringscalculator;

public class Calculator {

    public int calculate(String input) {
        if (isNullOrBlank(input)) {
            throw new IllegalArgumentException("입력값이 null이거나 빈 문자열");
        }
        String [] expression = input.split(" ");
        int firstOperand = Integer.parseInt(expression[0]);

        for (int i=1; i < expression.length; i = i+2) {
            firstOperand = calculate(firstOperand, Integer.parseInt(expression[i+1]), expression[i]);
        }

        return firstOperand;
    }

    private boolean isNullOrBlank(String input){
        return input == null || input.trim().isEmpty();
    }

    private int calculate(int firstOperand, int secondOperand, String operator) {
        if (operator.equalsIgnoreCase("+")) {
            return firstOperand + secondOperand;
        } else if (operator.equalsIgnoreCase("-")) {
            return firstOperand - secondOperand;
        } else if (operator.equalsIgnoreCase("*")) {
            return firstOperand * secondOperand;
        } else if (operator.equalsIgnoreCase("/")) {
            return firstOperand / secondOperand;
        }

        throw new IllegalArgumentException("사칙연산 기호가 아님");
    }
}
