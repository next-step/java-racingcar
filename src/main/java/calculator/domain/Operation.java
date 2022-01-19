package calculator.domain;

public class Operation {

    public static double addition(double result, int operand) {
        return result + (double) operand;
    }

    public static double subtraction(double result, int operand) {
        return result - (double) operand;
    }

    public static double multiplication(double result, int operand) {
        return result * (double) operand;
    }

    public static double division(double result, int operand) {
        return result / (double) operand;
    }

}
