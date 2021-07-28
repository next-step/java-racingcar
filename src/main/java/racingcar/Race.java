package racingcar;

public class Race {
    private final Cars cars;
    private final int tryNum;
    private final RaceStrategy strategy;

    public Race(int carNum, int tryNum, RaceStrategy strategy) {
        this.cars = new Cars(carNum);
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
            strategy.move(car);
        }
    }
}
