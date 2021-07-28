package racingcar;

public class Race {
    private final Cars cars;
    private final int tryNum;

    public Race(int carNum, int tryNum) {
        this.cars = new Cars(carNum);
        this.tryNum = tryNum;
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
            car.move();
        }
    }
}
