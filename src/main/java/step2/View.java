package step2;

import java.util.Scanner;

public class View {
    private static Scanner scanner = new Scanner(System.in);

    public static String readExpression() {
        System.out.println("수식을 입력하세요.");

        return scanner.nextLine();
    }

    public void printResult(int result) {
        System.out.println("결과: " + result);
    }
}
