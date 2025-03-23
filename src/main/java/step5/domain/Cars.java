package step5.domain;

import step5.util.MoveStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(String carNames) {
        cars = new ArrayList<>();
        Arrays.stream(carNames.split(","))
            .forEach(name -> cars.add(new Car(name, 0)));
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move(MoveStrategy moveStrategy) {
        for (Car car : cars) {
            car.go(moveStrategy);
        }
    }

    public List<Car> getAllCars() {
        return cars;
    }

    public List<Car> getWinners() {
        return filterWinners(getMaxLocation());
    }

    private Location getMaxLocation() {
        Location maxLocation = new Location(0);
        for (Car car : cars) {
            maxLocation = car.max(maxLocation);
        }
        return maxLocation;
    }

    private List<Car> filterWinners(Location maxLocation) {
        return cars.stream()
                .filter(car -> car.isSameLocation(maxLocation))
                .collect(Collectors.toList());
    }
}
