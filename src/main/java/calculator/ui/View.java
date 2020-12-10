package calculator.ui;

import java.util.Scanner;

public class View {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getUserInput() {
        System.out.println("계산식 입력");
        return scanner.nextLine();
    }

    public static void printResult(long result) {
        System.out.println("계산 결과: " + result);
    }

}
