package racinggame.ui;

import java.util.Scanner;

public class InputView {

    private static final String CAR_NAME_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분). ";
    private static final String ROUNDS_QUESTION = "시도할 회수는 몇 회 인가요? ";
    private static final String NOT_INTEGER = "정수로 재입력해주세요: ";

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
        throw new IllegalStateException("view class");
    }

    public static String promptCarName() {
        System.out.println(CAR_NAME_QUESTION);
        return SCANNER.next();
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
