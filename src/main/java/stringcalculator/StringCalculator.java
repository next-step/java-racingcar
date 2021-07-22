package stringcalculator;

public class StringCalculator {

    private static int operate(int firstNumber, char operator, int secondNumber) {
        if (operator == '-')
            return firstNumber - secondNumber;
        else if (operator == '*')
            return firstNumber * secondNumber;
        else if (operator == '/')
            return firstNumber / secondNumber;
        return firstNumber + secondNumber;
    }
}
