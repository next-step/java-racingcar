package racing;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static final int START_MOVE_VALUE = 0;

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public static Cars initCars(int carCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car(i, START_MOVE_VALUE));
        }
        return new Cars(cars);
    }

    public void moveCars() {
        Moving moving = new MovingRandom();
        for (Car car : cars) {
            car.move(moving);
        }
    }
}
