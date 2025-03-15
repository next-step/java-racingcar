package racingcar;

import java.util.List;

public class RacingCarService {

    private final List<Car> cars;
    private final int tryCount;

    public RacingCarService(List<Car> cars, int tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public List<Car> process() {
        for (int i = 0; i < tryCount; i++) {
            for (Car car : cars) {
                car.move();
            }
        }
        return cars;
    }
}
