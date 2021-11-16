package racingcar.domain;

import java.util.List;

public class GameInputData {

    private final List<String> carNames;
    private final int tryCount;

    private GameInputData(List<String> carNames, int tryCount) {

        this.carNames = carNames;
        this.tryCount = tryCount;
    }

    public static GameInputData of(List<String> carNames, int tryCount) {

        return new GameInputData(carNames, tryCount);
    }

    public int getTryCount() {

        return tryCount;
    }

    public List<String> getCarNames() {
        return carNames;
    }
}
