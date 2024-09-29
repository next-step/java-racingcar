package racingcar;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_CAR_COUNT = "자동차 대수는 몇 대 인가요?";
    private static final String INPUT_ATTEMPT_COUNT = "시도할 회수는 몇 회 인가요?";

    private InputView() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static int getCarCount() {
        System.out.println(INPUT_CAR_COUNT);
        return scanner.nextInt();
    }

    public static int getAttemptCount() {
        System.out.println(INPUT_ATTEMPT_COUNT);
        return scanner.nextInt();
    }
}
