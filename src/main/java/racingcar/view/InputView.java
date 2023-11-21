package racingcar.view;

import java.util.List;
import java.util.Scanner;
import racingcar.domain.PositiveNumber;

public class InputView {
    public static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String INPUT_NUMBER_OF_ATTEMPTS = "시도할 회수는 몇 회 인가요?";
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> carNames() {
        System.out.println(INPUT_CAR_NAMES);
        return List.of(scanner.nextLine().split(","));
    }

    public PositiveNumber numberOfAttempts() {
        System.out.println(INPUT_NUMBER_OF_ATTEMPTS);
        try {
            return readPositiveNumber();
        } finally {
            scanner.close();
        }
    }

    private PositiveNumber readPositiveNumber() {
        return new PositiveNumber(scanner.nextLine());
    }
}
