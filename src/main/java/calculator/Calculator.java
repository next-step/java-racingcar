package calculator;

public class Calculator {

    public static int calculate(int num1, int num2, String operator) {
        return Operator.calculate(operator, num1, num2);
    }

}
