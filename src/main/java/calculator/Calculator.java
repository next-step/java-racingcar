package calculator;

public class Calculator {
    private static final String DELIMITER = " ";
    private static final Integer ZERO = 0;
    private static final Integer INDEX_INTERVAL = 2;

    private Calculator() {
    }

    public static int calculate(String input) {
        inputValidate(input);

        String[] arr = input.split(DELIMITER);
        int sum = Integer.parseInt(arr[ZERO]);

        for (int i = 1; i < arr.length; i += INDEX_INTERVAL) {
            sum = calculator(sum , arr[i], Integer.parseInt(arr[i + 1]));
        }
        return sum;
    }

    private static int calculator(int firstOperand, String operator, int secondOperand) {
        if (operator.equals("+")) {
            return firstOperand + secondOperand;
        }
        if (operator.equals("-")) {
            return firstOperand - secondOperand;
        }
        if (operator.equals("*")) {
            return firstOperand * secondOperand;
        }
        if (operator.equals("/")) {
            divideValueZero(secondOperand);
            return firstOperand / secondOperand;
        }
        throw  new IllegalArgumentException("유효하지 않은 연산자 입니다.");
    }

    private static void divideValueZero(int operand) {
        if (operand == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
    }

    private static void inputValidate(String input) {
        if (input == null || input == "") {
            throw new IllegalArgumentException("입력값이 올바르지 않습니다.");
        }
    }
}
