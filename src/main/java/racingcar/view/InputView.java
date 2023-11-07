package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final String CAR_COUNT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String RACE_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";

    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public int readCarCount() {
        System.out.println(CAR_COUNT_MESSAGE);
        return readCount();
    }

    public int readRaceCount() {
        System.out.println(RACE_COUNT_MESSAGE);
        return readCount();
    }

    private int readCount() {
        return scanner.nextInt();
    }
}
