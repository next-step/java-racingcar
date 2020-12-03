package calculator.view;

import java.util.Scanner;

public class InputView {
    private static Scanner sc = new Scanner(System.in);

    public static String inputExpression() {
        System.out.println("계산식을 입력해주세요.");
        return sc.nextLine();
    }
}
