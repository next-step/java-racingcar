package racingcar.view;

import java.util.Scanner;

public final class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String CAR_NAMES_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TRY_NO_REQUEST_MESSAGE = "시도할 회수는 몇 회 인가요?";

    private InputView() {
    }

    public static String getCarNames() {
        print(CAR_NAMES_REQUEST_MESSAGE);
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