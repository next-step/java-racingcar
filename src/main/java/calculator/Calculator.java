package calculator;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        System.out.println("Step2  문자열 계산기");
        start();
    }

    private static void start() {
        String input = init();

        if (isBlank(input)) {
            throw new IllegalArgumentException(String.format("입력 데이터가 올바르지 않습니다. : [%s] ", input));
        }
    }

    private static boolean isBlank(String input) {
        return input == null || input.trim().isEmpty();
    }

    private static String init() {
        System.out.print("계산식을 입력하세요 = ");
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

}
