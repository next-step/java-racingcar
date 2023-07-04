package racing.model;

public class GameInfo {

    private String carNames;
    private int raceCount;

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
