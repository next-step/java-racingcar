package racing.view;

import java.util.Scanner;

public class InputView {

    public static String insertNamesOfCars() {
        Scanner scanner = new Scanner(System.in);
        printModelNamesMessage();

        return scanner.next();
    }

    public static int insertNumberOfCars() {
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

    private static void printModelNamesMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }
}
