package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final int INITIAL_LOCATION = 0;

    private final List<Car> cars;

    public Cars(final List<String> names) {
        this.cars = createCarsFrom(names);
    }

    private List<Car> createCarsFrom(final List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            Car car = new Car(name, INITIAL_LOCATION);
            cars.add(car);
        }
        return cars;
    }

    public void moveAll(final MovementCondition movementCondition) {
        for (Car car : cars) {
            car.moveOrStay(movementCondition);
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> selectWinners() {
        return getNamesOfWinners();
    }

    private List<String> getNamesOfWinners() {
        int farthest = getFarthestLocation();
        return cars.stream()
                .filter(c -> c.getLocation() == farthest)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getFarthestLocation() {
        int farthestLocation = 0;
        for (Car car : cars) {
            farthestLocation = max(farthestLocation, car);
        }
        return farthestLocation;
    }

    private int max(int farthestLocation, final Car car) {
        if (car.getLocation() > farthestLocation) {
            farthestLocation = car.getLocation();
        }
        return farthestLocation;
    }
}
