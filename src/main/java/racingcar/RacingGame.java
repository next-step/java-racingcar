package racingcar;

import java.util.List;

public class RacingGame {
    private final Cars cars;
    private final int tryCount;

    public RacingGame(List<String> carNames, int tryCount) {
        // TODO: validate()
        this.cars = new Cars(carNames);
        this.tryCount = tryCount;
    }

    public void start() {
        for (int i = 0; i < tryCount; i++) {
            // TODO: rename to `move()`
            cars.doRound(new MoveChecker());
        }
        cars.printWinners();
    }
}
