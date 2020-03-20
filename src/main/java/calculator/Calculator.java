package calculator;

public class Calculator {
    public static final int MOVE_STEP = 2;
    private static final String SEPARATOR = " ";
    private InputValidator validator = new InputValidator();

    public int calculate(String inputs) {
        validator.nullCheck(inputs);
        String[] inputArray = inputs.split(SEPARATOR);
        int sum = parseInt(inputArray[0]);
        for (int i = 1; i < inputArray.length; i = i + MOVE_STEP) {
            sum = operate(sum, inputArray[i], inputArray[i + 1]);
        }
        return sum;
    }

    private int operate(int leftNumber, String operator, String rightNumber) {
        validator.operatorCheck(operator);
        return operation(leftNumber, parseInt(rightNumber), operator);
    }

    private int operation(int leftNumber, int rightNumber, String operator) {
        if ("+".equals(operator)) {
            return add(leftNumber, rightNumber);
        }
        if ("-".equals(operator)) {
            return substract(leftNumber, rightNumber);
        }
        if ("*".equals(operator)) {
            return multiple(leftNumber, rightNumber);
        }
        return divide(leftNumber, rightNumber);
    }

    private int parseInt(String input) {
        return Integer.parseInt(input);
    }

    public int add(int left, int right) {
        return left + right;
    }

    public int substract(int left, int right) {
        return left - right;
    }

    public int multiple(int left, int right) {
        return left * right;
    }

    public int divide(int left, int right) {
        if(right == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return left / right;
    }

}
