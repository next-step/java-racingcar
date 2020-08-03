package racingcar.ui;

import java.util.Set;

public final class UserInputInfoWithCarNames {
    private final Set<String> carNames;
    private final int tryCount;

    public UserInputInfoWithCarNames(Set<String> carNames, int tryCount) {
        this.carNames = carNames;
        this.tryCount = tryCount;
    }

    public Set<String> getCarNames() {
        return carNames;
    }

    public int getTryCount() {
        return tryCount;
    }
}
