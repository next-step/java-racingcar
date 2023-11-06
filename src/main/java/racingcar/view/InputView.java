package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final String CAR_COUNT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String ATTEMPT_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";

    public int readCarCount() {
        System.out.println(CAR_COUNT_MESSAGE);
        return readCount();
    }

    public int readAttemptCount() {
        System.out.println(ATTEMPT_COUNT_MESSAGE);
        return readCount();
    }

    private int readCount() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
