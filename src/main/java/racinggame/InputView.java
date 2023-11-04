package racinggame;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    private static final String PRINTLN_CAR_SIZE = "자동차 대수는 몇 대 인가요?";
    private static final String PRINTLN_RACING_COUNT = "시도할 회수는 몇 회 인가요?";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public int carSize() {
        System.out.println(PRINTLN_CAR_SIZE);
        return inputNumber();
    }

    public int racingCount() {
        System.out.println(PRINTLN_RACING_COUNT);
        return inputNumber();
    }

    private int inputNumber() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException ex) {
            throw new MisMatchNumberException();
        }
    }

}
