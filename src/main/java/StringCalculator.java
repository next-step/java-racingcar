import java.util.Scanner;

public class StringCalculator {

    public String input() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public int makeResult(String input) {
        if (isBlank(input))
            throw new IllegalArgumentException();
        return calculateSplitedString(splitByBlank(input));
    }

    public boolean isBlank(String input) {
        if (input.equals(" ") || input == null) {
            return true;
        }
        return false;
    }

    private String[] splitByBlank(String input) {
        return input.split(" ");
    }

    private int calculateSplitedString(String[] str) {
        int result = convertToInt(str[0]);
        int calculateCount = str.length - 2;
        int numberStep = 2;
        for (int i = 0; i < calculateCount; i += numberStep) {
            result = calculate(result, str[i + 1].charAt(0), convertToInt(str[i + 2]));
        }
        return result;
    }

    private int convertToInt(String str) {
        return Integer.parseInt(str);
    }

    private int calculate(int firstNumber, char operator, int secondNumber) {
        if (operator == '+')
            return add(firstNumber, secondNumber);
        if (operator == '-')
            return subtract(firstNumber, secondNumber);
        if (operator == '*')
            return multiply(firstNumber, secondNumber);
        if (operator == '/')
            return divide(firstNumber, secondNumber);
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
        try {
            return dividedNumber / dividingNumber;
        } catch (IllegalArgumentException e) {
            System.out.println("숫자 0으로 나눌 수 없습니다.");
        }
        return dividedNumber / dividingNumber;
    }
}