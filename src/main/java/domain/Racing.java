package domain;

import java.util.ArrayList;
import java.util.List;

public class Racing {

    private List<Car> cars;

    public Racing(int carCount) {
        makeCar(carCount);
    }

    public void makeCar(int carCount) {
        this.cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    public void race(MovingStrategy movingStrategy) {
        for (Car car : cars) {
            car.move(movingStrategy.isMovable(movingStrategy.getIntValue()));
        }
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
