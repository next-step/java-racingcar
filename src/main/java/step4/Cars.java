package step4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Map<String, Integer> storeCarNameAndLocation() {
        Map<String, Integer> map = new HashMap<>();
        for (Car car : cars) {
            map.put(car.getCarName(), car.getLocation());
        }
        return map;
    }

    public void moveCar(RandomNumber randomNumber) {;
        for (Car car : cars) {
            car.moveLocation(randomNumber.generateRandomNumber());
        }
    }

    public List<String> findWinner() {
        List<String> carNames = new ArrayList<>();
        findMaxLocation(carNames, getMaxPosition());
        return carNames;
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = car.findMaxLocation(maxPosition);
        }
        return maxPosition;
    }

    private void findMaxLocation(List<String> carNames, int maxPosition) {
        for (Car car : cars) {
            addCarNames(carNames, maxPosition, car);
        }
    }

    private static void addCarNames(List<String> carNames, int maxPosition, Car car) {
        if (car.isMaxLocation(maxPosition)) {
            carNames.add(car.getCarName());
        }
    }
}
