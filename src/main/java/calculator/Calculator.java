package calculator;

public class Calculator {

    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";

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

        if (PLUS.equals(operator)) {
            return Calculator.add(number1, number2);
        }

        if (MINUS.equals(operator)) {
            return Calculator.subtract(number1, number2);
        }

        if (MULTIPLY.equals(operator)) {
            return Calculator.multiply(number1, number2);
        }

        if (DIVIDE.equals(operator)) {
            return Calculator.divide(number1, number2);
        }
        
        throw new IllegalArgumentException("해당 연산자는 존재하지 않습니다 operator = " + operator);
    }
}
