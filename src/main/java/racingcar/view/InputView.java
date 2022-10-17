package racingcar.view;

import java.util.Scanner;

public final class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String CAR_NO_REQUEST_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String TRY_NO_REQUEST_MESSAGE = "시도할 회수는 몇 회 인가요?";

    private InputView() {
    }

    public static String getCarNo() {
        print(CAR_NO_REQUEST_MESSAGE);
        return getUserInput();
    }

    public static String getTryNo() {
        print(TRY_NO_REQUEST_MESSAGE);
        return getUserInput();
    }

    private static void print(final String message) {
        System.out.println(message);
    }

    private static String getUserInput() {
        return SCANNER.nextLine().trim();
    }

}