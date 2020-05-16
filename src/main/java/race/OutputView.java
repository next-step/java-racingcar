package race;

import java.util.Arrays;
import java.util.stream.IntStream;

public final class OutputView {

    private static final String PATH = "-";
    private static final int START_POSITION= 0;
    private OutputView() {}

    public static void print(RacingGame racingGame) {
        System.out.println();
        System.out.println("실행 결과");

        startRacing(racingGame);
    }

    private static void startRacing(RacingGame racingGame) {
        final int time = racingGame.getTime();
        final int[] carPositions = racingGame.getCarPositions();

        for (int i = 0; i < time; i++) {
            racingGame.move();
            startRacingCars(carPositions);
            System.out.println();
        }
    }

    private static void startRacingCars(int[] carPositions) {
        Arrays.stream(carPositions).forEach(OutputView::startRacingCar);
    }

    private static void startRacingCar(int carPosition) {
        final StringBuilder sb = new StringBuilder();
        IntStream.range(START_POSITION, carPosition).forEach(position -> sb.append(PATH));
        System.out.println(sb.toString());
    }
}
