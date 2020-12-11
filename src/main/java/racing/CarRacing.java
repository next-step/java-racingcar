package racing;

public class CarRacing {

    private final Cars cars;
    private final MoveStrategy moveStrategy;
    private int raceCount;

    public CarRacing(Cars cars, MoveStrategy moveStrategy, int raceCount) {
        this.cars = cars;
        this.moveStrategy = moveStrategy;
        this.raceCount = raceCount;
    }

    public void race() {
        cars.moveAll(moveStrategy);
        raceCount--;
    }

    public boolean isComplete() {
        return raceCount == 0;
    }
}
