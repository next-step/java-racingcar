package racingcar.domain;

import java.util.List;

public class UserInputData {

    private final List<String> carNames;
    private final int tryCount;

    public UserInputData(List<String> carNames, int tryCount) {
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
