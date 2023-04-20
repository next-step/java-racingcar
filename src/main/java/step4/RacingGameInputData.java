package step4;

public class RacingGameInputData {
    private int tryCount;
    private String[] carNames;

    public RacingGameInputData(int tryCount, String[] carNames) {
        this.tryCount = tryCount;
        this.carNames = carNames;
    }

    public int getTryCount() {
        return tryCount;
    }

    public String[] getCarNames() {
        return carNames;
    }
}

