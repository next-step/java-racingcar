package calculator.domain;

public class Operation {

    public static double addition(double accumulator, double operand) {
        return accumulator + (double) operand;
    }

    public static double subtraction(double accumulator, double operand) {
        return accumulator - (double) operand;
    }

    public static double multiplication(double accumulator, double operand) {
        return accumulator * (double) operand;
    }

    public static double division(double accumulator, double operand) {
        return accumulator / (double) operand;
    }

}
