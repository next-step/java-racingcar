package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> names) {
        this.cars = names.stream()
            .map(Car::new)
            .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

    public void moveCar(int index) {
        cars.get(index).move();
    }

    public String convertCarsStatus() {
        return cars.stream()
            .map(Car::convertCarStatus)
            .collect(Collectors.joining());
    }

    public String convertWinner() {
        return calculateWinners().stream()
            .map(Car::getName)
            .collect(Collectors.joining(", "));
    }

    private List<Car> calculateWinners() {
        int maxDistance = calculateMaxDistance();
        return cars.stream()
            .filter(car -> car.getDistance() == maxDistance)
            .collect(Collectors.toList());
    }

    private int calculateMaxDistance() {
        return cars.stream()
            .mapToInt(Car::getDistance).max()
            .orElseThrow(NoSuchElementException::new);
    }
}
