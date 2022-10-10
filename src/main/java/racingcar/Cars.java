package racingcar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createCarsByNumber(int number) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            cars.add(new Car());
        }
        return new Cars(cars);
    }

    public static Cars createCarsByNames(List<String> names) {
        List<Car> cars = new ArrayList<>();
        for (String name: names) {
            cars.add(new Car(name));
        }
        return new Cars(cars);
    }

    public List<Car> getCars() {
        return cars;
    }

    public int findMaxPosition() {
        return cars.stream()
            .max(Comparator.comparingInt(Car::getPosition))
            .orElseThrow()
            .getPosition();
    }
}
