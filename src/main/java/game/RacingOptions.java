package game;

public class RacingOptions {
    private final int carCount;
    private final int racingRep;

    public RacingOptions(int carCount, int racingRep) {
        this.carCount = carCount;
        this.racingRep = racingRep;
    }

    public int racingRep() {
        return racingRep;
    }

    public int carCount() {
        return carCount;
    }
}