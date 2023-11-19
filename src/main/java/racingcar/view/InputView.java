package racingcar.view;

import java.util.Scanner;
import racingcar.domain.PositiveNumber;

public class InputView {

    public static final String INPUT_NUMBER_OF_CARS = "자동차 대수는 몇 대 인가요?";
    public static final String INPUT_NUMBER_OF_ATTEMPTS = "시도할 회수는 몇 회 인가요?";
    public static final String INPUT_NUMBER_OF_CARS_EXCEPTION = "입력한 자동차 갯수가 올바르지 않습니다.";
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public PositiveNumber numberOfCars() {
        System.out.println(INPUT_NUMBER_OF_CARS);
        try {
            return readPositiveNumber();
        } catch (IllegalArgumentException e) {
            scanner.close();
            throw new IllegalArgumentException(INPUT_NUMBER_OF_CARS_EXCEPTION);
        }
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
