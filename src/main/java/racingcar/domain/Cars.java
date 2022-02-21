package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> carNames) {
        cars = makeCarsByCarNames(carNames);
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getMaxMovingDistance() {
        int maxMovingDistance = 0;

        for (Car car : cars) {
            if (car.isFartherThan(maxMovingDistance)) {
                maxMovingDistance = car.getPosition();
            }
        }
        return maxMovingDistance;
    }

    private List<Car> makeCarsByCarNames(List<String> carNames) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
        return cars;
    }
}
