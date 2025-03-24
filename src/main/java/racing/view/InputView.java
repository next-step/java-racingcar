package racing.view;

import racing.config.GameConfig;
import racing.domain.model.Cars;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public GameConfig promptForGameConfig() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Cars cars = new Cars(splitInput(scanner.next()));

        System.out.println("시도할 회수는 몇 회 인가요?");
        int attemptCount = scanner.nextInt();

        return new GameConfig(cars, attemptCount);
    }

    private String[] splitInput(final String input) {
        return input.split(",");
    }

    public void close() {
        scanner.close();
    }
}
