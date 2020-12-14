package step2.view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static String readExpression() {
        System.out.println("수식을 입력하세요.");

        return scanner.nextLine();
    }
}
