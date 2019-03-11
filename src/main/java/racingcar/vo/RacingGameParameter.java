package racingcar.vo;

import java.util.List;

public class RacingGameParameter {
    private final List<String> carNames;
    private final int tryCount;

    public RacingGameParameter(List<String> carNames, int tryCount) {
        this.carNames = carNames;
        this.tryCount = tryCount;
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public int getTryCount() {
        return tryCount;
    }
}
