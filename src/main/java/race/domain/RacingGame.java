package race.domain;

public class RacingGame {

    private final Cars cars;
    private final MoveStrategy moveStrategy;

    public RacingGame(Cars cars, MoveStrategy moveStrategy) {
        this.cars = cars;
        this.moveStrategy = moveStrategy;
    }

    public void play() {
        for (Car car : cars.cars()) {
            car.move(moveStrategy);
        }
    }
}
