package racing.domain;

public class GameInfo {

    private final String carNames;
    private final int raceCount;

    public GameInfo(String carNames, int raceCount) {
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
