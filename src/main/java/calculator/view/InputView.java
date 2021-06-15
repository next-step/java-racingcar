package calculator.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String inputString() {
        System.out.println("문자열을 입력하세요.");

        return SCANNER.nextLine();
    }
}
