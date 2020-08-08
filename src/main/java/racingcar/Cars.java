package racingcar;

import racingcar.common.RandomGenerator;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private final Car[] cars;

    private Cars(String[] namesOfCars) {
        int size = namesOfCars.length;

        this.cars = new Car[size];

        for (int i = 0; i < size; ++i) {
            cars[i] = Car.createCar(namesOfCars[i]);
        }
    }

    public static Cars createAllCars(String[] namesOfCars) {
        return new Cars(namesOfCars);
    }

    public void moveCars() {
        for (Car car : this.cars) {
            int fuel = RandomGenerator.generateRandomInt();

            car.move(fuel);
        }
    }

    public List<CarState> getStates() {
        List<CarState> states = new ArrayList<>();

        for (Car car : this.cars) {
            states.add(car.getState());
        }

        return states;
    }

    private int getMaxPosition() {
        Car car =  Arrays.stream(this.cars)
                .max(Car::compareTo)
                .orElseThrow(()->new NoSuchElementException("승자가 없습니다."));

        return car.getPosition();
    }

    public List<String> findByMaxPosition() {
        int maxPosition = getMaxPosition();

        return Arrays.stream(this.cars)
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::toString)
                .collect(Collectors.toList());
    }
}
