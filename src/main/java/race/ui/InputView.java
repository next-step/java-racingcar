package race.ui;

import java.util.Scanner;

public class InputView {
    private final static Scanner SCANNER = new Scanner(System.in);
    private final static String CARS_COUNT_DESCRIPTION = "자동차 대수는 몇 대 인가요?";
    private final static String RACE_ATTEMPT_DESCRIPTION = "시도할 회수는 몇 회 인가요?";

    public static int inputCarsCount() {
        System.out.println(CARS_COUNT_DESCRIPTION);
        return SCANNER.nextInt();
    }

    public static int inputRaceAttemptCount() {
        System.out.println(RACE_ATTEMPT_DESCRIPTION);
        return SCANNER.nextInt();
    }
}
