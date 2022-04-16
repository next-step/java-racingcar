package racing.view;

import java.util.Scanner;

public class InputView {
    private static final String ATTEMPTS_COUNT_MESSAGE = "시도할 횟수는 몇 회 인가요?";
    private static final String RACING_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String inputRacingCarNames() {
        showMessage(RACING_CAR_NAME_MESSAGE);
        return SCANNER.next();
    }

    public static int inputAttemptsCount() {
        showMessage(ATTEMPTS_COUNT_MESSAGE);
        return SCANNER.nextInt();
    }

    private static void showMessage(String carCountMessage) {
        System.out.println(carCountMessage);
    }

}
