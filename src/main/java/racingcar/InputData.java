package racingcar;

import java.util.List;

public class InputData {
    private List<String> carNames;
    private int tryCount;

    public InputData(List<String> carNames, int tryCount) {
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
