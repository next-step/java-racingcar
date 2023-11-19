package racing4.domain;

public class Race4Command {
    private String[] carNames;
    private int tryCount;

    public Race4Command(String[] carNames, int tryCount) {
        this.carNames = carNames;
        this.tryCount = tryCount;
    }

    public String[] getCarNames() {
        return carNames;
    }

    public int getTryCount() {
        return tryCount;
    }
}
