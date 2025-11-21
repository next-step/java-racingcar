package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {

    private static final int MAX_RANDOM_VALUE = 10;

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

    public void moveAll(Random random) {
        for (Car car : cars) {
            car.moveIfPossible(random.nextInt(MAX_RANDOM_VALUE));
        }
    }

    private List<Car> createCars(List<CarName> carNames) {
        List<Car> cars = new ArrayList<>();
        for (CarName carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }
}
