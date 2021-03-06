package study.step2;

public class Calculator {

    public Calculator() {
    }

    public int plus(int number1, int number2) {
        return number1 + number2;
    }

    public int minus(int number1, int number2) {
        return number1 - number2;
    }

    public int multiple(int number1, int number2) {
        return number1 * number2;
    }

    public int divide(int number1, int number2) {
        return number1 / number2;
    }

    public int operate(String operator, int num1, int num2) {
        if("+".equals(operator)) {
            return plus(num1, num2);
        }
        if("-".equals(operator)) {
            return minus(num1, num2);
        }
        if("*".equals(operator)) {
            return multiple(num1, num2);
        }
        return divide(num1, num2);
    }
}
