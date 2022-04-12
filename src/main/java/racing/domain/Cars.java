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

    public Cars newInstance() {
        List<Car> newCars = new ArrayList<>(cars.size());
        for (int i = 0, len = cars.size(); i < len; i++) {
            newCars.add(i, cars.get(i).newInstance());
        }

        return new Cars(newCars);
    }

    private List<Car> initCars(int unit) {
        List<Car> cars;
        cars = new ArrayList<>(unit);
        for (int i = 0; i < unit; i++) {
            cars.add(i, new Car());
        }
        return cars;
    }
}
