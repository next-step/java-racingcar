package racingcar.domain;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {

    private static final int INITIAL_LOCATION = 0;

    private final Set<Car> cars;

    public Cars(final List<String> names) {
        this.cars = createCarsFrom(names);
    }

    private Set<Car> createCarsFrom(final List<String> carNames) {
        Set<Car> cars = new LinkedHashSet<>();
        for (String name : carNames) {
            Car car = new Car(name, INITIAL_LOCATION);
            cars.add(car);
        }
        return cars;
    }

    public void moveAll(final MovementCondition movementCondition) {
        for (Car car : cars) {
            car.moveOrStay(movementCondition);
            car.printNameAndCurrentPosition();
        }
        System.out.println();
    }

    public void selectWinners() {
        List<String> winners = getNamesOfWinners();
        System.out.println("최종 우승자: " + String.join(", ", winners));
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
