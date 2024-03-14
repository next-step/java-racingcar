package step3and4.car;

import step3and4.car.move.RandomMoveStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarEntry {
    private final List<Car> cars;

    public static CarEntry from(List<Car> cars) {
        if (cars == null) {
            return new CarEntry(new ArrayList<>());
        }
        return new CarEntry(cars);
    }

    public CarEntry(List<Car> cars) {
        this.cars = cars;
    }

    public static CarEntry create(String[] carNames, RandomMoveStrategy randomMoveStrategy) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++) {
            cars.add(createCar(carNames[i], randomMoveStrategy));
        }
        return from(cars);
    }

    public static Car createCar(String carNames, RandomMoveStrategy randomMoveStrategy) {
        return new Car(carNames, randomMoveStrategy);
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

    public List<String> getCarNames() {
        return this.cars.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public String[] getWinCars() {
        int winPosition = createWinPosition();

        return this.cars.stream()
                .filter(car -> car.equalsPosition(winPosition))
                .map(Car::getName)
                .collect(Collectors.toList()).toArray(new String[0]);
    }

    private int createWinPosition() {
        int winPosition = this.cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
        return winPosition;
    }
}
