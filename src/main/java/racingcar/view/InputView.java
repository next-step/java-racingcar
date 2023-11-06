package racingcar.view;

import java.util.Scanner;

public class InputView {

    public static final String INPUT_NUMBER_OF_CARS = "자동차 대수는 몇 대 인가요?";
    public static final String INPUT_NUMBER_OF_ATTEMPTS = "시도할 회수는 몇 회 인가요?";
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public int numberOfCars() {
        System.out.println(INPUT_NUMBER_OF_CARS);
        try {
            return getInputNumber();
        } catch (Exception e) {
            scanner.close();
            throw new RuntimeException(e);
        }
    }

    public int numberOfAttempts() {
        System.out.println(INPUT_NUMBER_OF_ATTEMPTS);
        try {
            return getInputNumber();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            scanner.close();
        }
    }

    private int getInputNumber() {
        return Integer.parseInt(scanner.nextLine());
    }
}
