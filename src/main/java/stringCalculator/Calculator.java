package stringCalculator;


import java.util.HashSet;
import java.util.Set;

public class Calculator {

    private String input;
    private String[] parsedInput;
    private Set<Character> validOperators;

    Calculator(String input) {
        this.input = input;

        // Operator 검증을 위한 Set 설정
        String operator = "+-*/";
        validOperators = new HashSet<>();
        for (int i = 0; i < operator.length(); i++)
            validOperators.add(operator.charAt(i));

        // input 검증
        checkInputValidity();
        parsedInput = input.split(" ");
        checkParsedInputValidity();

    }

    private void checkInputValidity() {
        if (input == null || input.isEmpty())
            throw new IllegalArgumentException("Input is invalid form");
    }

    private void checkParsedInputValidity() {
        checkOperatorValidity();
        checkPair();
    }

    private void checkOperatorValidity() {
        for (int idx = 1; idx < parsedInput.length; idx += 2)
            checkOperator(parsedInput[idx]);
    }

    private void checkPair() {
        if (parsedInput.length % 2 == 0)
            throw new IllegalArgumentException("Input doesn't match pair");
    }

    private void checkOperator(String input) {
        if (!(input.length() == 1 && validOperators.contains(input.charAt(0))))
            throw new IllegalArgumentException();
    }

    int execute() {
        int result;

        result = calculate();

        return result;
    }

    int calculate() {

        int result = Integer.parseInt(parsedInput[0]);

        for (int idx = 1; idx < parsedInput.length; idx += 2) {

            String operator = parsedInput[idx];
            String operand = parsedInput[idx + 1];

            result = calculateWithOperator(result, operator, operand);

        }

        return result;
    }

    int calculateWithOperator(int result, String operator, String operand) {
        if (operator.equals("+")) {
            return result + Integer.parseInt(operand);
        } else if (operator.equals("-")) {
            return result - Integer.parseInt(operand);
        } else if (operator.equals("*")) {
            return result * Integer.parseInt(operand);
        } else if (operator.equals("/")) {
            return result / Integer.parseInt(operand);
        }
        return result;
    }
}
