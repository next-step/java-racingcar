package step3and4.car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarFirstCollection {
    private final List<Car> cars;

    public static CarFirstCollection from(List<Car> cars) {
        if (cars == null) {
            return new CarFirstCollection(new ArrayList<>());
        }
        return new CarFirstCollection(cars);
    }

    public CarFirstCollection(List<Car> cars) {
        this.cars = cars;
    }

    public void moveCars() {
        cars.stream().forEach(Car::move);
    }

    public List<Car> getCars() {
        return cars;
    }

    public int[] createMoveResult() {
        return this.cars.stream()
                .mapToInt(Car::getPosition)
                .toArray();
    }

    public int size() {
        return this.getCars().size();
    }

    public String[] getCarNames() {
        return this.cars.stream()
                .map(Car::getName)
                .collect(Collectors.toList())
                .toArray(new String[0]);
    }

    public String[] getWinCars() {
        int winPosition = createWinPosition();

        return this.cars.stream()
                .filter(car -> !car.comparePosition(winPosition))
                .map(Car::getName)
                .collect(Collectors.toList()).toArray(new String[0]);
    }

    private int createWinPosition() {
        int winPosition = this.cars.stream()
                .sorted()
                .mapToInt(Car::getPosition)
                .findFirst()
                .orElse(0);
        return winPosition;
    }
}
