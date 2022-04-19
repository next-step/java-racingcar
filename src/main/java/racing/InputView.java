package racing;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_CAR_COUNT_MESSAGE = "자동차 대수는 몇대 인가요?";
    private static final String INPUT_RACING_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";


    public static int inputCarCount(Scanner scanner) {
        System.out.println(INPUT_CAR_COUNT_MESSAGE);
        return scanner.nextInt();
    }

    public static int inputRacingCount(Scanner scanner) {
        System.out.println(INPUT_RACING_COUNT_MESSAGE);
        return scanner.nextInt();
    }
}
