package racingcar.domain;

public class RaceInput {
    private String[] carNames;
    private int tryCount;
    public RaceInput() {
    }

    public String[] getCarNames() {
        return carNames;
    }

    public int getTryCount() {
        return tryCount;
    }

    public void setCarNames(String[] carNames) {
        this.carNames = carNames;
    }

    public void setTryCount(int tryCount) {
        this.tryCount = tryCount;
    }
}
