package calculator;

import java.util.Scanner;

public class CalculatorView {
    private static final Scanner scanner = new Scanner(System.in);

    public String inputString() {
        System.out.println("문자열을 입력하세요.");

        return scanner.nextLine();
    }

    public void showResult(int result) {
        System.out.println("결과값 : " + result);
    }
}
