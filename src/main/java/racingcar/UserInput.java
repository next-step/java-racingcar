package racingcar;

import java.util.Scanner;

public class UserInput {
    public static final String QUESTION_FOR_TOTAL_CAR_COUNT = "자동차 대수는 몇 대 인가요?";
    public static final String QUESTION_FOR_TOTAL_MOVE_COUNT = "시도할 회수는 몇 회 인가요?";

    private final Integer totalCarCount;
    private final Integer totalMoveCount;

    public UserInput(int totalCarCount, int totalMoveCount) {
        this.totalCarCount = totalCarCount;
        this.totalMoveCount = totalMoveCount;
    }

    public Race readyForRace() {
        return new Race(this.totalCarCount, this.totalMoveCount);
    }

    public static UserInput getUserInputFromScanner() {
        Scanner scanner = new Scanner(System.in);

        askTotalCarCount();
        int totalCarCount = scanner.nextInt();

        askTotalMoveCount();
        int totalMoveCount = scanner.nextInt();

        return new UserInput(totalCarCount, totalMoveCount);
    }

    private static void askTotalMoveCount() {
        System.out.println(QUESTION_FOR_TOTAL_MOVE_COUNT);
    }

    private static void askTotalCarCount() {
        System.out.println(QUESTION_FOR_TOTAL_CAR_COUNT);
    }
}
