package racing.view;

import racing.config.GameConfig;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public GameConfig promptForGameConfig() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int attemptCount = scanner.nextInt();

        return new GameConfig(carCount, attemptCount);
    }

    public void close() {
        scanner.close();
    }
}