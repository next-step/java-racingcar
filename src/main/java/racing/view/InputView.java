package racing.view;

import java.util.Scanner;

public class InputView {
    private static final String CAR_COUNT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String ATTEMPTS_COUNT_MESSAGE = "시도할 횟수는 몇 회 인가요?";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int inputCarCount() {
        showMessage(CAR_COUNT_MESSAGE);

        return SCANNER.nextInt();
    }

    public static int inputAttemptsCount() {
        showMessage(ATTEMPTS_COUNT_MESSAGE);

        return SCANNER.nextInt();
    }

    private static void showMessage(String carCountMessage) {
        System.out.println(carCountMessage);
    }

}
