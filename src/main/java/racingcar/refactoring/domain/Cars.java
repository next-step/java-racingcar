package racingcar.refactoring.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public Map<String, Integer> moveAll() {
        for (Car car : cars) {
            car.move();
        }
        return createNamePositionMap();
    }

    public Map<String, Integer> createNamePositionMap() {
        Map<String, Integer> current = new LinkedHashMap<>();
        for (Car car : cars) {
            current.put(car.getName(), car.getPosition());
        }
        return current;
    }
}
