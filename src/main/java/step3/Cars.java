package step3;

import java.util.*;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveCarsByStrategy(MoveStrategy moveStrategy) {
        for (Car car : cars) {
            car.move(moveStrategy);
        }
    }

    public Map<String, Integer> showCarsPositions() {
        Map<String, Integer> carsPositions = new HashMap<>();
        for (Car car : cars) {
            carsPositions.put(car.getName(), car.getPosition());
        }
        return carsPositions;
    }
}
