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
            int result = Calculator.equality(input);
            printResult(result);
        } catch (IllegalArgumentException ex) {
            printErrorMessage(ex);
        }
    }

    private static void printResult(int result) {
        System.out.printf("정답은 %d 입니다.%n", result);
    }

    private static void printErrorMessage(IllegalArgumentException ex) {
        String printMsg = "형식에 맞지 않는 수식입니다.";

        String exMessage = ex.getMessage();
        if(exMessage != null && !exMessage.isEmpty()) {
            printMsg = String.format("%s(%s)",printMsg, exMessage);
        }

        System.out.println(printMsg);
    }

    private static String scanInput() {
        System.out.println("사칙연산 수식을 입력해 주세요(종료: q): ");
        return scanner.nextLine();
    }

    private static boolean isQuitApp(String input) {
        if(input.equals("q")) {
            System.out.println("사칙 계산기를 종료합니다.");
            return true;
        }
        return false;
    }
}
