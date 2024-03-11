package racingCar;

public class RacingCar {

    private static final int START_LOCATION = 0;
    private final MoveStrategy strategy;
    int location;

    public RacingCar(MoveStrategy strategy) {
        this.strategy = strategy;
        this.location = START_LOCATION;
    }

    public int findCurrentLocation() {
        return this.location;
    }

    public void move(int distance) {
        if (strategy.isMovable(distance)) {
            this.location++;
        }
    }
}
