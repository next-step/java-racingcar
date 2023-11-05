package racinggame;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    private static final String PRINTLN_CAR_SIZE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String PRINTLN_RACING_COUNT = "시도할 회수는 몇 회 인가요?";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String carName() {
        System.out.println(PRINTLN_CAR_SIZE);
        return scanner.next();
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
