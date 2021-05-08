import java.util.Scanner;

public class StringCalculator {

    public String input() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public int makeResult(String input) {
        if (isBlank(input))
            throw new RuntimeException();
        return calculateSplitedString(splitBlank(input));
    }

    private boolean isBlank(String input) {
        if (input.equals(" ") || input == null)
            return true;
        return false;
    }

    private String[] splitBlank(String str) {
        return str.split(" ");
    }

    private int calculateSplitedString(String[] str) {
        int result = toInt(str[0]);
        for (int i = 0; i < str.length - 2; i += 2) {
            result = calculate(result, str[i + 1].charAt(0), toInt(str[i + 2]));
        }
        return result;
    }

    private int toInt(String str) {
        return Integer.parseInt(str);
    }

    private int calculate(int firstValue, char operator, int secondValue) {
        if (operator == '+')
            return add(firstValue, secondValue);
        if (operator == '-')
            return subtract(firstValue, secondValue);
        if (operator == '*')
            return multiply(firstValue, secondValue);
        if (operator == '/')
            return divide(firstValue, secondValue);
        throw new RuntimeException();
    }

    private int add(int i, int j) {
        return i + j;
    }

    private int subtract(int i, int j) {
        return i - j;
    }

    private int multiply(int i, int j) {
        return i * j;
    }

    private int divide(int i, int j) {
        try {
            return i / j;
        } catch (ArithmeticException e) {
            System.out.println("숫자 0으로 나눌 수 없습니다.");
        }
        return i / j;
    }
}