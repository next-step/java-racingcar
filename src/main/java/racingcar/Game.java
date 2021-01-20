package racingcar;

import java.util.List;

public class Game {
    private final Cars cars;
    private final int tryCount;

    public Game(List<String> carNames, int tryCount, final MoveChecker moveChecker) {
        this.cars = new Cars(carNames, moveChecker);
        this.tryCount = tryCount;
    }

    public void start() {
        for (int i = 0; i < tryCount; i++) {
            cars.doRound();
        }
        cars.printWinners();
    }
}
