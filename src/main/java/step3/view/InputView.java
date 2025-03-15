package step3.view;

import java.util.Scanner;

public class InputView {
    static Scanner scanner = new Scanner(System.in);

    public static String inputCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return getInput();
    }

    public static String inputTryCount() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return getInput();
    }

    private static String getInput() {
        return scanner.nextLine();
    }

    public static void closeScanner() {
        scanner.close();
    }
}
