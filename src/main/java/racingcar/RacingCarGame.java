package racingcar;

import java.util.Scanner;

public class RacingCarGame {

    public static final String QUESTION_FOR_TOTAL_CAR_COUNT = "자동차 대수는 몇 대 인가요?";
    public static final String QUESTION_FOR_TOTAL_MOVE_COUNT = "시도할 회수는 몇 회 인가요?";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        askTotalCarCount();
        int totalCarCount = scanner.nextInt();

        askTotalMoveCount();
        int totalMoveCount = scanner.nextInt();

        Race race = new Race(totalCarCount, totalMoveCount);
        race.start();
    }

    private static void askTotalMoveCount() {
        System.out.println(QUESTION_FOR_TOTAL_MOVE_COUNT);
    }

    private static void askTotalCarCount() {
        System.out.println(QUESTION_FOR_TOTAL_CAR_COUNT);
    }
}
