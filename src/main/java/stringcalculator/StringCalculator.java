package stringcalculator;

public class StringCalculator {
    private static final String BLANK = " ";
<<<<<<< HEAD
=======
    private static final String SEPARATOR = " ";
>>>>>>> origin/step2

    public void checkBlank(String input) {
        if (input == null || input.equals(BLANK)) {
            throw new IllegalArgumentException("입력값이 null이거나 빈 공백 문자입니다.");
        }
    }

    public String[] splitBySeparator(String input) {
<<<<<<< HEAD
        String separator = " ";
        return input.split(separator);
    }

    public int calculateSplitString(String[] splitString) {
        int result = convertToInt(splitString[0]);
        int numberOfOperations = splitString.length - 2;
        int intervalBetweenNumbers = 2;
        for (int i = 0; i < numberOfOperations; i += intervalBetweenNumbers) {
            result = calculateTwoNumbers(result, splitString[i + 1].charAt(0), convertToInt(splitString[i + 2]));
=======
        return input.split(SEPARATOR);
    }

    public int calculateSplitString(String[] splitString) {
        int result = Integer.parseInt(splitString[0]);
        int numberOfOperations = splitString.length - 2;
        int intervalBetweenNumbers = 2;
        for (int i = 0; i < numberOfOperations; i += intervalBetweenNumbers) {
            result = calculateTwoNumbers(result, splitString[i + 1].charAt(0), Integer.parseInt(splitString[i + 2]));
>>>>>>> origin/step2
        }
        return result;
    }

<<<<<<< HEAD
    private int convertToInt(String stringNumber) {
        return Integer.parseInt(stringNumber);
    }

=======
>>>>>>> origin/step2
    private int calculateTwoNumbers(int firstNumber, char operator, int secondNumber) {
        if (operator == '+') {
            return add(firstNumber, secondNumber);
        }
        if (operator == '-') {
            return subtract(firstNumber, secondNumber);
        }
        if (operator == '*') {
            return multiply(firstNumber, secondNumber);
        }
        if (operator == '/') {
            return divide(firstNumber, secondNumber);
        }
        throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
    }

    private int add(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    private int subtract(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }

    private int multiply(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }

    private int divide(int dividedNumber, int dividingNumber) {
        if (dividingNumber == 0) {
            throw new IllegalArgumentException("숫자 0으로 나눌 수 없습니다.");
        }
        return dividedNumber / dividingNumber;
    }
}