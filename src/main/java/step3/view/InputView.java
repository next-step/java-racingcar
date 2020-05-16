package step3.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private static final String RACING_CAR_COUNT_QUESTION = "자동차 대수는 몇 대 인가요?";
    private static final String MOVE_COUNT_QUESTION = "시도할 회수는 몇 회 인가요?";

    private InputView() {
    }

    public static int getRacingCarCount() {
        System.out.println(RACING_CAR_COUNT_QUESTION);
        return scanner.nextInt();
    }

    public static int getGameRound() {
        System.out.println(MOVE_COUNT_QUESTION);
        return scanner.nextInt();
    }
}
