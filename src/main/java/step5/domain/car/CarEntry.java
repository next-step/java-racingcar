package step5.domain.car;

import step5.domain.car.move.random.RandomMoveStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarEntry {
    private final List<Car> cars;

    public static CarEntry fromCarList(List<Car> cars) {
        if (cars == null) {
            return new CarEntry(new ArrayList<>());
        }
        return new CarEntry(cars);
    }

    public CarEntry(List<Car> cars) {
        this.cars = cars;
    }

    public static CarEntry create(String[] carNames, RandomMoveStrategy randomMoveStrategy) {
        return fromCarList(createCarList(carNames, randomMoveStrategy));
    }

    private static List<Car> createCarList(String[] carNames, RandomMoveStrategy randomMoveStrategy) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++) {
            cars.add(createCar(carNames[i], randomMoveStrategy));
        }
        return cars;
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

    public List<String> getWinCars() {
        return createWinPositionCars(createWinPosition());
    }

    private List<String> createWinPositionCars(int winPosition) {
        return this.cars.stream()
                .filter(car -> car.equalsPosition(winPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int createWinPosition() {
        int winPosition = this.cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
        return winPosition;
    }
}
