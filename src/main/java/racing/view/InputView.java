package racing.view;

import java.util.Scanner;

public class InputView {
    private static final String DELIMITER = ",";

    public static String[] insertNamesOfCars() {
        Scanner scanner = new Scanner(System.in);
        printModelNamesMessage();

        return split(scanner.next());
    }

    public static int insertNumberOfAttempts() {
        Scanner scanner = new Scanner(System.in);
        printAttemptsMessage();

        return scanner.nextInt();
    }

    public static String[] split(String text) {
        String[] carNames = text.split(DELIMITER);

        return carNames;
    }

    private static void printAttemptsMessage() {
        System.out.println("시도할 회수는 몇 회 인가요?");
    }

    private static void printModelNamesMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }
}
