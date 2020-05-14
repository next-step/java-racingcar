package calculator;

public class StringCalculator {

    private static final String SUPPORT_OPERATOR = "+-*/";
    private static final String DELIMITER = " ";

    public int calculate(String input) {
        validateInput(input);

        String[] splitInput = input.split(" ");

        int answer = Integer.parseInt(splitInput[0]);
        for (int i = 1; i < splitInput.length; i += 2) {
            String operator = splitInput[i];
            int number = Integer.parseInt(splitInput[i + 1]);

            validateOperator(operator);

            if (operator.equals("+")) {
                answer = add(answer, number);
            }
            if (operator.equals("-")) {
                answer = subtract(answer, number);
            }
            if (operator.equals("*")) {
                answer = multiply(answer, number);
            }
            if (operator.equals("/")) {
                answer = division(answer, number);
            }
        }

        return answer;
    }

    private void validateInput(String input) {
        if (input == null || input.isEmpty() || input.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (input.split(DELIMITER).length % 2 == 0) {
            throw new IllegalArgumentException();
        }
    }

    private void validateOperator(String operator) {
        if (!SUPPORT_OPERATOR.contains(operator)) {
            throw new IllegalArgumentException();
        }
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

    public int division(int number1, int number2) {
        if (number2 == 0) {
            throw new ArithmeticException();
        }
        return number1 / number2;
    }

}
