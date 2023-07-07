package racing.model;

public class GameInfo {

    private final String carNames;
    private final int raceCount;

    public GameInfo(final String carNames, final int raceCount) {
        this.carNames = carNames;
        this.raceCount = raceCount;
    }

    public String getCarNames() {
        return carNames;
    }

    public int getRaceCount() {
        return raceCount;
    }

}
