package racing.domain;

import java.util.List;

public class RacingCarGame {

    private static int round = 0;

    public static Cars initialize(List<String> carNames, int moveCount) {
        return new Cars(carNames, moveCount);
    }

    public static void progress(Cars cars) {
        cars.move();
        round += 1;
    }

    public static boolean isStart() {
        return round == 0;
    }
}
