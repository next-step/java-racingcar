package calculator;

public class Calculator {
    private final Expression expression;

    public Calculator(Expression expression) {
        this.expression = expression;
    }
    public String calculate() {
        String result = expression.of(0);
        for(int i = 1; i < expression.length() - 1; i=i+2) {
            result = calculate(expression.of(i), result, expression.of(i+1));
        }
        return result;
    }
    public static String calculate(String operator, String num1, String num2) {
        if(operator.equals("+")) {
            return addition(num1, num2);
        }
        if(operator.equals("-")) {
            return subtraction(num1, num2);
        }
        if(operator.equals("*")) {
            return multiplication(num1, num2);
        }
        if(operator.equals("/")) {
            return division(num1, num2);
        }
        throw new IllegalArgumentException( operator + " is not operator");
    }

    private static String addition(String num1, String num2) {
        return String.valueOf(Integer.parseInt(num1) + Integer.parseInt(num2));
    }

    private static String subtraction(String num1, String num2) {
        return String.valueOf(Integer.parseInt(num1) - Integer.parseInt(num2));
    }

    private static String multiplication(String num1, String num2) {
        return String.valueOf(Integer.parseInt(num1) * Integer.parseInt(num2));
    }

    private static String division(String num1, String num2) {
        return String.valueOf(Integer.parseInt(num1) / Integer.parseInt(num2));
    }
}
