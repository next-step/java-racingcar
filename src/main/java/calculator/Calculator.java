package calculator;

public class Calculator {

    public static void main(String[] args) {
        InternalCalculator calculator = new InternalCalculator();
        try {
            calculator.startCalculator();
        } catch (IllegalArgumentException e) {
            PrintUtils.printError();
        }
    }
}
