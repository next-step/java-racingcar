package step2;

import java.util.Scanner;

public class CalculatorMain {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String target = scanner.nextLine();
            play(target);
        }
    }

    private static void play(String target) {
        if (checkInputString(target)) {
            Calculator calculator = new Calculator();
            Integer result = calculator.calculate(target);
            printResult(result);
        }
    }

    public static boolean checkInputString(String input) {
        if (input == null || input.length() == 0) {
            throw new IllegalArgumentException("null 또는 빈값을 입력할 수 없습니다");
        }
        return true;
    }

    public static void printResult(Integer result) {
        System.out.println(result);
    }
}
