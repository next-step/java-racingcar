package racingcar.view;

public class RacingRequest {
    private final String carNames;
    private final int tryCount;

    public RacingRequest(String carNames, int tryCount) {
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
