package racingcar;

import java.util.Scanner;

public class ConsoleReader {

    private static final String CAR_COUNT_MESSAGE = "자동차 대수는 몇 대 인가요?";

    private static final String TRIAL_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";

    private final Scanner scanner = new Scanner(System.in);

    private int readNumber() {
        return scanner.nextInt();
    }

    public int inputCarCount() {
        System.out.println(CAR_COUNT_MESSAGE);
        return readNumber();
    }

    public int inputTrialCount() {
        System.out.println(TRIAL_COUNT_MESSAGE);
        return readNumber();
    }


}
