package racingcar.refactoring.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Cars {

    private final List<Car> cars;
    private static final MovingStrategy randomMovingStrategy = new RandomMovingStrategy();

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public Map<String, Integer> moveAll() {
        for (Car car : cars) {
            car.moveForward(randomMovingStrategy);
        }
        return createNamePositionMap();
    }

    public Map<String, Integer> createNamePositionMap() {
        Map<String, Integer> result = new LinkedHashMap<>();
        for (Car car : cars) {
            result.put(car.getName(), car.getPosition());
        }
        return result;
    }
}
