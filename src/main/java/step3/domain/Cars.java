package step3.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(int carNumbers, MoveStrategy moveStrategy) {
        this.cars = new ArrayList<>();

        for (int i = 0; i < carNumbers; i++) {
            cars.add(new Car(moveStrategy));
        }
    }

    public Cars(int carNumbers, String[] carNames, MoveStrategy moveStrategy) {
        this.cars = new ArrayList<>();

        for (int i = 0; i < carNumbers; i++) {
            cars.add(new Car(carNames[i], moveStrategy));
        }
    }

    public void moveCars() {
        for (Car car : cars) {
            car.moveForwardOnChance();
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<String> searchWinners() {
        int maxDistance = cars.stream()
                .mapToInt(Car::getCurrentLocation)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.isAtMaxDistance(maxDistance))
                .map(Car::getName)
                .collect(Collectors.toUnmodifiableList());
    }
}
