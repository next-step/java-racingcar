package step3;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {

    private final List<Car> cars;
    private final int tryCount;

    public CarRacing(int carCount, int tryCount) {
        this.cars = new ArrayList<>();
        this.tryCount = tryCount;

        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    public void racingStart() {
        for (int i = 0; i < tryCount; i++) {
            ResultView.printResult(racing());
        }
    }

    private List<Car> racing() {
        for (Car car : cars) {
            car.moveForward(CarUtils.getNumberForMovement());
        }
        return cars;
    }
}
