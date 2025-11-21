package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<CarName> names) {
        this.cars = createCars(names);
    }

    public static Cars fromCars(List<Car> cars) {
        Cars instance = new Cars(List.of());
        instance.cars.addAll(cars);
        return instance;
    }

    public List<Car> allCars() {
        return cars;
    }

    private List<Car> createCars(List<CarName> carNames) {
        List<Car> cars = new ArrayList<>();
        for (CarName carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }
}
