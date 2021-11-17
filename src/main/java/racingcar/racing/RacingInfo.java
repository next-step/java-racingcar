package racingcar.racing;

public class RacingInfo {
    private final int cars;
    private final int laps;

    public RacingInfo(int cars, int laps) {
        this.cars = cars;
        this.laps =laps;
    }

    public int getCars() {
        return this.cars;
    }

    public int getLaps() {
        return this.laps;
    }
}
