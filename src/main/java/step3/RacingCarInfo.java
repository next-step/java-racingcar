package step3;

import java.util.List;

public class RacingCarInfo {
    public final List<Car> cars;
    public final Integer tryCount;

    public RacingCarInfo(List<Car> cars, Integer tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }
}
