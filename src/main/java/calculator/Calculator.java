package calculator;

public class Calculator {

    private Calculator() {
    }

    static Number add(Number number1, Number number2) {
        return number1.add(number2);
    }

    static Number subtract(Number number1, Number number2) {
        return number1.subtract(number2);
    }

    static Number multiply(Number number1, Number number2) {
        return number1.multiply(number2);
    }

    static Number divide(Number number1, Number number2) {
        return number1.divide(number2);
    }

    static Number calculate(Number number1, String operator, Number number2) {
        switch (operator) {
            case "+":
                return Calculator.add(number1, number2);
            case "-":
                return Calculator.subtract(number1, number2);
            case "*":
                return Calculator.multiply(number1, number2);
            case "/":
                return Calculator.divide(number1, number2);
            default:
                throw new IllegalArgumentException("해당 연산자는 존재하지 않습니다 operator = " + operator);
        }
    }
}
