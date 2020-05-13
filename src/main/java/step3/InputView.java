package step3;

import java.util.Scanner;

public class InputView {

    private static final String RACING_CAR_COUNT_QUESTION = "자동차 대수는 몇 대 인가요?";
    private static final String MOVE_COUNT_QUESTION = "시도할 회수는 몇 회 인가요?";

    private int racingCarCount;
    private int moveCount;

    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public void show() {
        System.out.println(RACING_CAR_COUNT_QUESTION);
        this.racingCarCount = scanner.nextInt();

        System.out.println(MOVE_COUNT_QUESTION);
        this.moveCount = scanner.nextInt();
    }

    public int getRacingCarCount() {
        return this.racingCarCount;
    }

    public int getMoveCount() {
        return this.moveCount;
    }
}
