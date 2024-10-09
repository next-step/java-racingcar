package step3;

import java.util.*;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveCarsByStrategy() {
        for (Car car : cars) {
            car.move(new RandomMoveStrategy());
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
