package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static String askEquation() {
        System.out.println("계산할 문자열을 입력해주세요(공백으로 구분)");
        return SCANNER.nextLine();
    }
}
