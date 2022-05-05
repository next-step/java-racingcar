package racingcar.view;

import java.util.Scanner;

public class InputView {
    private InputView() {

    }

    private final static Scanner SCANNER = new Scanner(System.in);
    private final static String INPUT_RACING_CAR_COUNT = "자동차 대수는 몇대 인가요?";
    private final static String INPUT_ATTEMPT_COUNT = "시도할 회수는 몇 회 인가요?";

    public static int inputCarCount() {
        System.out.println(INPUT_RACING_CAR_COUNT);
        return SCANNER.nextInt();
    }

    public static int inputAttemptCount() {
        System.out.println(INPUT_ATTEMPT_COUNT);
        return SCANNER.nextInt();
    }
}
