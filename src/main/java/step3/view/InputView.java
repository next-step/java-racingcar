package step3.view;

import step3.game.PositiveNumber;

import java.util.Scanner;

public class InputView {
    static Scanner scanner = new Scanner(System.in);

    public static PositiveNumber inputCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return new PositiveNumber(getInput());
    }

    public static PositiveNumber inputTryCount() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return new PositiveNumber(getInput());
    }

    private static String getInput() {
        return scanner.nextLine();
    }

    public static void closeScanner() {
        scanner.close();
    }
}
