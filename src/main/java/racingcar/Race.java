package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private List<Car> cars = new ArrayList<>();
    private int tryNum;

    public Race(int carNum, int tryNum) {
        for (int i = 0; i < carNum; i++) {
            cars.add(new Car());
        }
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
