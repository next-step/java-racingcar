package racing.view;

import java.util.Scanner;

public class InputView {

    public static int insertNumberOfModel() {
        Scanner scanner = new Scanner(System.in);
        printModelMessage();

        return scanner.nextInt();
    }

    public static int insertNumberOfAttempts() {
        Scanner scanner = new Scanner(System.in);
        printAttemptsMessage();

        return scanner.nextInt();
    }

    private static void printModelMessage() {
        System.out.println("자동차 대수는 몇 대 인가요?");
    }

    private static void printAttemptsMessage() {
        System.out.println("시도할 회수는 몇 회 인가요?");
    }
}
