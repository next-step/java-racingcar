package calculator;

import java.util.Scanner;

public class CalculatorApp {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while(true) {
            String input = scanInput();

            if (isQuitApp(input))
                break;

            calculate(input);
        }

    }

    private static void calculate(String input) {
        try {
            Integer result = Calculator.equality(input);
            System.out.printf("정답은 %d 입니다.%n", result);
        } catch (IllegalArgumentException ex) {
            System.out.println("정확하지 않은 수식입니다.");
        }
    }

    private static String scanInput() {
        System.out.println("사칙연산 수식을 입력해 주세요(종료: q): ");
        String input = scanner.nextLine();
        return input;
    }

    private static boolean isQuitApp(String input) {
        if(input.equals("q")) {
            System.out.println("사칙 계산기를 종료합니다.");
            return true;
        }
        return false;
    }
}
