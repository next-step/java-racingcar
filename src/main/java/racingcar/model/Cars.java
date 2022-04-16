package racingcar.model;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    public Cars(MovingStrategy movingStrategy, String[] names) {
        this(new Position(), movingStrategy, names);
    }

    Cars(Position position, MovingStrategy movingStrategy, String[] names) {
        for (String name : names) {
            cars.add(new Car(position, movingStrategy, name));
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public void runRace() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<String> getWinnerNames() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.currentPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        Comparator<Car> comparatorByPosition = Comparator.comparingInt(Car::currentPosition);
        return cars.stream()
                .max(comparatorByPosition)
                .orElseThrow(NoSuchElementException::new)
                .currentPosition();
    }
}
