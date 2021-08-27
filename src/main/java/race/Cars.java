package race;

import java.util.*;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createCars(List<Car> cars) {
        for (int i = cars.size(); i > 0; i--) {
            Car car = new Car();
            cars.add(car);
        }
        return new Cars(cars);
    }

    protected final List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    protected Cars moveCars(Cars cars, MoveCondition moveCondition) {
        for (Car car : cars.getCars()) {
            car.addDistance(moveCondition);
        }
        return cars;
    }

}
