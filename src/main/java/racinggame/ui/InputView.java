package racinggame.ui;

import java.util.Scanner;

public class InputView {

    public static final String CAR_COUNT_QUESTION = "자동차 대수는 몇 대 인가요? ";
    public static final String ROUNDS_QUESTION = "시도할 회수는 몇 회 인가요? ";
    public static final String NOT_INTEGER = "정수로 재입력해주세요: ";

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
        throw new IllegalStateException("view class");
    }

    public static int promptCarCount() {
        System.out.println(CAR_COUNT_QUESTION);
        return scanNumber();
    }

    public static int promptRounds() {
        System.out.println(ROUNDS_QUESTION);
        return scanNumber();
    }

    private static int scanNumber() {
        while (!SCANNER.hasNextInt()) {
            SCANNER.next();
            System.err.print(NOT_INTEGER);
        }

        return SCANNER.nextInt();
    }

}
