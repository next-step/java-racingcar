package calculator;

public class Calculator {
    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";
    
    public static int add(int first, int second) {
        return first + second;
    }

    public static int subtract(int first, int second) {
        return first - second;
    }

    public static int multiply(int first, int second) {
        return first * second;
    }

    public static int divide(int first, int second) {
        return first / second;
    }

    public static int run(InputString inputString) {
        inputString.split();
        int result = Integer.MIN_VALUE;

        if (isFirst(result)) {
            result = firstCalculate(inputString);
        }

        while (checkState(inputString)) {
            result = calculate(inputString.getOperator(), result, inputString.getOneNumber());
        }

        return result;
    }

    private static int firstCalculate(InputString inputString) {
        int first = inputString.getOneNumber();
        int second = inputString.getOneNumber();
        String operator = inputString.getOperator();

        return calculate(operator, first, second);
    }

    private static boolean isFirst(int result) {
        return result == Integer.MIN_VALUE;
    }

    private static int calculate(String operator, int first, int second) {
        if(isAdd(operator)) {
            return add(first, second);
        }
        
        if(isSubtract(operator)) {
            return subtract(first, second);
        }
        
        if(isMultiply(operator)) {
            return multiply(first, second);
        }

        return divide(first, second);
    }

    private static boolean checkState(InputString inputString) {
        return inputString.numberCount() > 0 && inputString.operatorCount() > 0;
    }
    
    private static boolean isAdd(String operator) {
        return operator.equals(PLUS);
    }
    
    private static boolean isSubtract(String operator) {
        return operator.equals(MINUS);
    }
    
    private static boolean isMultiply(String operator) {
        return operator.equals(MULTIPLY);
    }
}
