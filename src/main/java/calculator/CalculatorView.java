package calculator;

import java.util.Scanner;

public class CalculatorView {
    public String inputString() {
        System.out.println("문자열을 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        String str;

        str = scanner.nextLine();
        return str;
    }

    public void showResult(int result) {
        System.out.println("결과값 : " + result);
    }
}
