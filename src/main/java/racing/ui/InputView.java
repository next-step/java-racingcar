package racing.ui;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private static final String CAR_COUNT_QUESTION = "자동차 대수는 몇 대 인가요?";

    private static final String ROUND_COUNT_QUESTION = "시도할 횟수는 몇 회 인가요?";

    public static int readCarCount() {
        System.out.println(CAR_COUNT_QUESTION);
        return scanner.nextInt();
    }

    public static int readRoundCount() {
        System.out.println(ROUND_COUNT_QUESTION);
        return scanner.nextInt();
    }
}
