package racingcar.domain;

public class Race {
    private final Cars cars;
    private final int tryNum;
    private final RaceStrategy strategy;

    public Race(Cars cars, int tryNum, RaceStrategy strategy) {
        this.cars = cars;
        this.tryNum = tryNum;
        this.strategy = strategy;
    }

    public RaceResult play() {
        RaceResult result = new RaceResult();
        for (int i = 0; i < tryNum; i++) {
            moveCars();
            result.recordLap(cars);
        }
        return result;
    }

    private void moveCars() {
        for (Car car : cars) {
            moveByStrategy(car);
        }
    }

    private void moveByStrategy(Car car) {
        if (strategy.decideToMove()) {
            car.move();
        }
    }
}
