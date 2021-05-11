import java.util.Scanner;

public class StringCalculator {

    public String inputString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public int calculate(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException();
        }
        System.out.println(calculateSplitedString(splitBySeparator(input)));
        return calculateSplitedString(splitBySeparator(input));
    }

    public boolean isBlank(String input) {
        return input == " " || input == null;
    }

    private String[] splitBySeparator(String input) {
        String separator = " ";
        return input.split(separator);
    }

    private int calculateSplitedString(String[] splitedString) {
        int result = convertToInt(splitedString[0]);
        int calculateCount = splitedString.length - 2;
        int numberStep = 2;
        for (int i = 0; i < calculateCount; i += numberStep) {
            result = calculateTwoNumbers(result, splitedString[i + 1].charAt(0), convertToInt(splitedString[i + 2]));
        }
        return result;
    }

    private int convertToInt(String stringNumber) {
        return Integer.parseInt(stringNumber);
    }

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
        throw new IllegalArgumentException();
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
        if ( dividingNumber == 0 ) {
            throw new IllegalArgumentException("숫자 0으로 나눌 수 없습니다.");
        }
        return dividedNumber / dividingNumber;
    }
}