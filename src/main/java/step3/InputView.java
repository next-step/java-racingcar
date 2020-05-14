package step3;

import java.util.Scanner;

public class InputView {

    private static final String RACING_CAR_COUNT_QUESTION = "자동차 대수는 몇 대 인가요?";
    private static final String MOVE_COUNT_QUESTION = "시도할 회수는 몇 회 인가요?";

    private final int racingCarCount;
    private final int gameRound;

    private InputView() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(RACING_CAR_COUNT_QUESTION);
        this.racingCarCount = scanner.nextInt();

        System.out.println(MOVE_COUNT_QUESTION);
        this.gameRound = scanner.nextInt();
    }

    public static InputView create() {
        return new InputView();
    }

    public int getRacingCarCount() {
        return this.racingCarCount;
    }

    public int getGameRound() {
        return this.gameRound;
    }
}
