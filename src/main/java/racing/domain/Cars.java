package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    Cars(int unit) {
        this.cars = initCars(unit);
    }

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    Cars move(Movable movable) {
        List<Car> carList = new ArrayList<>(cars.size());
        for (Car car : cars) {
            carList.add(car.move(movable));
        }
        return new Cars(carList);
    }

    private List<Car> initCars(int unit) {
        List<Car> cars = new ArrayList<>(unit);
        for (int i = 0; i < unit; i++) {
            cars.add(i, new Car());
        }
        return cars;
    }
}
