package step4.dto;

public class RacingGameCondition {
    private String carNames;
    private int tryCount;

    public RacingGameCondition(String carNames, int tryCount) {
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
