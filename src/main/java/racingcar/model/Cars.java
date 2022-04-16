package racingcar.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    public void create(MovingStrategy movingStrategy, String[] names) {
        for (String name : names) {
            cars.add(createCar(new Position(), movingStrategy, name));
        }
    }

    public Car createCar(Position position, MovingStrategy movingStrategy, String name) {
        return new Car(position, movingStrategy, name);
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
