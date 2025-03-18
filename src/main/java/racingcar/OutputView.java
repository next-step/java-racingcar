package racingcar;

import java.util.stream.IntStream;

public class OutputView {

    private static final String DISTANCE_UNIT = "-";

    public static void askCarNumbers() {
        System.out.println("자동차 대수는 몇 대 인가요?");
    }

    public static void askRoundNumbers() {
        System.out.println("시도할 회수는 몇 회 인가요?");
    }

    public static void showRace(Racing racing, int numberOfRounds) {
        System.out.println("\n실행결과");

        IntStream.range(0, numberOfRounds).forEach(i -> {
            racing.playRound();
            System.out.println(racing.getRacingStatus());
        });
    }
}