package step2;

import java.util.Scanner;

public class CalculatorMain {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String target = scanner.nextLine();
            calculate(target);
        }
    }

    private static void calculate(String target) {
        if (checkInputString(target)) {
            Calculator calculator = new Calculator();
            String[] stringArray = calculator.splitStringByBlankValue(target);
            calculator.setUpNumbersAndOperations(stringArray);
            calculator.calculateNumber();
            calculator.printResult();
        }
    }

    public static boolean checkInputString(String input) {
        if (input == null || input.length() == 0) {
            throw new IllegalArgumentException("null 또는 빈값을 입력할 수 없습니다");
        }
        return true;
    }
}
