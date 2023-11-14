package racingcar.domain;

import racingcar.movablestrategy.MovableStrategy;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public Cars(int carCount) {
        this.cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    public Cars(String racerNames) {
        this.cars = new ArrayList<>();
        String[] names = Car.nameSplitByDelimiter(racerNames);
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public boolean carsReady(int racingCondition) {
        return cars.size() >= racingCondition;
    }

    public List<CarStatDTO> race(MovableStrategy movableStrategy) {
        List<CarStatDTO> carStatDTOS = new ArrayList<>();
        for (Car car : cars) {
            carStatDTOS.add(car.move(movableStrategy));
        }
        return carStatDTOS;
    }

    public int size() {
        return cars.size();
    }

    public List<CarStatDTO> mostFastestCar() {
        int maxPosition = measurementMaxPosition();
        return findCarByPosition(maxPosition);
    }

    private int measurementMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = car.fasterPosition(maxPosition);
        }
        return maxPosition;
    }

    private List<CarStatDTO> findCarByPosition(int position) {
        return cars.stream()
                .filter(car -> car.isSamePosition(position))
                .map(car -> car.carStatDTO())
                .collect(Collectors.toList());
    }
}
