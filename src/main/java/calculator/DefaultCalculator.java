package calculator;

public interface DefaultCalculator {

    default int add(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }
}
