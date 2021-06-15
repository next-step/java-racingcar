package calculator;

import java.util.Scanner;

public class CalculatorView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String inputString() {
        System.out.println("문자열을 입력하세요.");

        return SCANNER.nextLine();
    }

    public static void showResult(int result) {
        System.out.println("결과값 : " + result);
    }
}
