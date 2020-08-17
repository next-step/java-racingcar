package racing.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> names, int location) {
        cars = new ArrayList<>();

        for (String name : names) {
            add(new Car(name, location));
        }
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    private void add(Car car) {
        cars.add(car);
    }

    public void racingOneGame(MovableRule movableRule) {
        for (Car car : cars) {
            racing(car, movableRule.isMovable());
        }
    }

    private void racing(Car car, boolean isMovable) {
        if (isMovable) {
            car.go();
        }
    }

    public Map<String, Integer> getTrackRecords() {
        Map<String, Integer> trackRecords = new LinkedHashMap<>();
        for (Car car : cars) {
            trackRecords.put(car.getName(), car.getLocation());
        }

        return trackRecords;
    }

    public List<Car> findWinner() {
        Car winner = findFirstWinner();

        return cars.stream()
                .filter(car -> car.isEqualLocation(winner))
                .collect(Collectors.toList());
    }

    private Car findFirstWinner() {
        Collections.sort(cars);
        return cars.get(0);
    }

}
