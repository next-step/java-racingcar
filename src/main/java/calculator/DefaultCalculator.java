package calculator;

public interface DefaultCalculator {

    default int addition(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    default int substraction(int firstNumber, int secondNumber){
        return firstNumber - secondNumber;
    }
}
