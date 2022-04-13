package racing.view;

import java.util.Scanner;

public class InputView {
    public static final String CAR_COUNT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    public static final String ATTEMPTS_COUNT_MESSAGE = "시도할 횟수는 몇 회 인가요?";
    private final int carCount;
    private final int attemptsCount;

    public InputView() {
        Scanner scanner = new Scanner(System.in);

        showMessage(CAR_COUNT_MESSAGE);
        this.carCount = scanner.nextInt();

        showMessage(ATTEMPTS_COUNT_MESSAGE);
        this.attemptsCount = scanner.nextInt();
    }

    private void showMessage(String carCountMessage) {
        System.out.println(carCountMessage);
    }

    public int getCarCount() {
        return carCount;
    }

    public int getAttemptsCount() {
        return attemptsCount;
    }
}
