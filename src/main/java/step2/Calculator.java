package step2;

public class Calculator {
    private int number1;

    public Calculator(int number) {
        this.number1 = number;
    }

    public int calculate(String operator, int number2) {
        if("+".equals(operator)) {
            return add(number1, number2);
        }
        if("-".equals(operator)) {
            return subtract(number1, number2);
        }
        if("*".equals(operator)) {
            return multiply(number1, number2);
        }
        if("/".equals(operator)) {
            return divide(number1, number2);
        }

        throw new IllegalArgumentException();
    }

    private int add(int number1, int number2) {
        return number1 + number2;
    }

    private int subtract(int number1, int number2) {
        return number1 - number2;
    }

    private int multiply(int number1, int number2) {
        return number1 * number2;
    }

    private int divide(int number1, int number2) {
        return number1 / number2;
    }
}
