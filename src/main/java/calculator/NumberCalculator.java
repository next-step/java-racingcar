package calculator;

public class NumberCalculator {
    public double add(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }

    public double subtract(double firstNumber, double secondNumber) {
        return firstNumber - secondNumber;
    }

    public double multiply(double firstNumber, double secondNumber) {
        return firstNumber * secondNumber;
    }

    public double divide(double firstNumber, double secondNumber) {
        if (secondNumber == 0)
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        return firstNumber / secondNumber;
    }
}
