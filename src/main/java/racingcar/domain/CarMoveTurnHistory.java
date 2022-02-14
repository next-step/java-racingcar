package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarMoveTurnHistory {

    private final List<Car> carMoveTurnHistory;

    private CarMoveTurnHistory() {
        carMoveTurnHistory = new ArrayList<>();
    }

    public static CarMoveTurnHistory create() {
        return new CarMoveTurnHistory();
    }

    public List<Car> getCarMoveTurnHistory() {
        return carMoveTurnHistory;
    }

    public void add(Car car) {
        carMoveTurnHistory.add(car);
    }
}
