package study;

import java.util.Scanner;

public class Calculator {
    public String input() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public boolean isBlank(String input) {
        if (input.equals(" ") || input == null || input.equals(""))
            return true;
        return false;
    }

    public int makeResult(String input) {
        if (isBlank(input))
            throw new IllegalArgumentException();
        return calculateSplitedString(splitBlank(input));
    }

    public String[] splitBlank(String str) {
        return str.split(" ");
    }

    public int calculateSplitedString(String[] str) {
        int result = Integer.parseInt(str[0]);
        for (int i = 0; i < str.length - 2; i += 2) {
            result = calculate(result, str[i + 1].charAt(0), Integer.parseInt(str[i + 2]));
        }
        return result;
    }

    public int calculate(int firstValue, char operator, int secondValue) {
        if (operator == '+')
            return add(firstValue, secondValue);
        else if (operator == '-')
            return subtract(firstValue, secondValue);
        else if (operator == '*')
            return multiply(firstValue, secondValue);
        else if (operator == '/')
            return divide(firstValue, secondValue);
        else
            throw new IllegalArgumentException();
    }

    public int add(int i, int j) {
        return i + j;
    }

    public int subtract(int i, int j) {
        return i - j;
    }

    public int multiply(int i, int j) {
        return i * j;
    }

    public int divide(int i, int j) {
        try {
            return i / j;
        } catch (ArithmeticException e) {
            System.out.println("숫자 0으로 나눌 수 없습니다.");
        }
        return i / j;
    }
}
