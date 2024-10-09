package racingcar.domain;

public class UserInputData {

    private final String carNames;
    private final int tryCount;

    public UserInputData(String carNames, int tryCount) {
        this.carNames = carNames;
        this.tryCount = tryCount;
    }

    public String getCarNames() {
        return carNames;
    }

    public int getTryCount() {
        return tryCount;
    }
}
