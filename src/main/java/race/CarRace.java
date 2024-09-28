package race;

import java.util.ArrayList;
import java.util.List;

public class CarRace {

    private List<Car> cars = new ArrayList<>();
    private int tryCount;


    public CarRace(int carCount, int tryCount, List<Car> cars) {
        this.cars.addAll(cars);
        this.tryCount = tryCount;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> start() {
        for (int i = 0; i < tryCount; i++) {
            checkCarForward();
        }

        return cars;
    }

    private void checkCarForward() {
        for (Car car : cars) {
            car.forward(car.getConditionNumber());
        }
    }
}
