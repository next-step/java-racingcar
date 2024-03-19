package RacingGame.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarsManager {
    private List<Car> cars = new ArrayList<>();

    public CarsManager(List<Car> cars) {
        this.cars = cars;
    }

    public static CarsManager withCarCount(int carCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }

        return new CarsManager(cars);
    }

    public static CarsManager withCarNames(List<String> carNames) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        return new CarsManager(cars);
    }

    public void tryMoveCars(MovableStrategy movableStrategy) {
        for (Car car : cars) {
            car.move(movableStrategy);
        }
    }

    public List<Integer> getCarsPosition() {
        List<Integer> list = new ArrayList<>();

        for (Car car : cars) {
            list.add(car.getPosition());
        }

        return list;
    }

    public List<Car> winners() {
        int highestPosition = findHighestPosition();

        return this.cars.stream()
                .filter(car -> car.isPositionAt(highestPosition))
                .collect(Collectors.toList());
    }

    private int findHighestPosition() {
        int highestPosition = Integer.MIN_VALUE;

        for (Car car : cars) {
            highestPosition = Math.max(highestPosition, car.getPosition());
        }

        return highestPosition;
    }

    public List<String> winnerNames() {
        List<Car> winners = winners();
        return winners.stream()
                .map(Car::name).collect(Collectors.toList());
    }

    public List<Car> cars() {
        return cars;
    }
}
