package racingcar;

import racingcar.movablestrategy.MovableStrategy;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public Cars(int carCount) {
        this(carCount, () -> true);
    }

    public Cars(int carCount, MovableStrategy movableStrategy) {
        this.cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car("noName", movableStrategy));
        }
    }

    public Cars(String racerNames, MovableStrategy movableStrategy) {
        this.cars = new ArrayList<>();
        String[] names = Car.nameSplitByComma(racerNames);
        for (String name : names) {
            cars.add(new Car(name, movableStrategy));
        }
    }

    public boolean carsReady(int racingCondition) {
        return cars.size() >= racingCondition;
    }

    public void race() {
        for (Car car : cars) {
            car.move();
        }
    }

    public int size() {
        return cars.size();
    }

    public List<Car> mostFastestCar() {
        int maxPosition = measurementMaxPosition();
        return findCarByPosition(maxPosition);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    private int measurementMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = car.fasterPosition(maxPosition);
        }
        return maxPosition;
    }

    private List<Car> findCarByPosition(int position) {
        return cars.stream()
                .map(car -> samePositionRacerSelection(car, position))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private Car samePositionRacerSelection(Car car, int position) {
        if (car.isSamePosition(position)) {
            return car;
        }
        return null;
    }
}
