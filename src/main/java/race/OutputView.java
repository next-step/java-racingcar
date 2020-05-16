package race;

import java.util.stream.IntStream;

public final class OutputView {

    private static final String PATH = "-";
    private static final int START_IDX = 0;
    private OutputView() {}

    public static void print(RacingGame racingGame) {
        System.out.println("실행 결과");
        final int time = racingGame.getTime();
        final int[] carPositions = racingGame.getCarPositions();
        for (int i = 0; i < time; i++) {
            racingGame.move();
            for (int carPosition : carPositions) {
                printCarPosition(carPosition);
            }
            System.out.println();
        }
    }

    private static void printCarPosition(int carPosition) {
        final StringBuilder sb = new StringBuilder();
        IntStream.range(START_IDX, carPosition).forEach(position -> sb.append(PATH));
        System.out.println(sb.toString());
    }
}
