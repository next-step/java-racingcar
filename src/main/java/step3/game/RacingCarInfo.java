package step3.game;

import java.util.ArrayList;
import java.util.List;

public class RacingCarInfo {
    public final List<Car> cars;
    public final Integer tryCount;

    private RacingCarInfo(List<Car> cars, Integer tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public static RacingCarInfo getCars(PositiveNumber carCount, PositiveNumber tryCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount.number; i++) {
            cars.add(new Car());
        }
        return new RacingCarInfo(cars, tryCount.number);
    }
}
