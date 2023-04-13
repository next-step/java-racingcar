package racingcar;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private static final String QUESTION_FOR_TOTAL_CAR_COUNT = "자동차 대수는 몇 대 인가요?";
    private static final String QUESTION_FOR_TOTAL_MOVE_COUNT = "시도할 회수는 몇 회 인가요?";

    @Override
    public Race setRace() {
        Scanner scanner = new Scanner(System.in);

        askTotalCarCount();
        int totalCarCount = scanner.nextInt();

        askTotalMoveCount();
        int totalMoveCount = scanner.nextInt();

        return new Race(totalCarCount, totalMoveCount);
    }

    private static void askTotalMoveCount() {
        System.out.println(QUESTION_FOR_TOTAL_MOVE_COUNT);
    }

    private static void askTotalCarCount() {
        System.out.println(QUESTION_FOR_TOTAL_CAR_COUNT);
    }
}
