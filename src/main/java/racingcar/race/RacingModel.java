package racingcar.race;

public class RacingModel {
    protected static final int MOVE_POSSIBLE = 4;
    private int tryCount;
    private RacingCars cars;

    public RacingModel(String[] names, int tryCount) {
        cars = RacingCars.of(names);
        this.tryCount = tryCount;
    }

    public int getTryCount() {
        return tryCount;
    }

    public RacingCars getCars() {
        return cars;
    }
}
