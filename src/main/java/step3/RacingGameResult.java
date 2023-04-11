package step3;

import java.util.List;

public class RacingGameResult {

    private final Cars cars;

    public RacingGameResult(Cars cars) {
        this.cars = cars;
    }

    public static RacingGameResult makeResult(Cars cars) {
        return new RacingGameResult(cars);
    }

    public List<Integer> getCarPositions() {
        return cars.getPositions();
    }
}
