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

    public Map<String, Integer> getState() {
        Map<String, Integer> stateOfCars = new HashMap<>();

        for (Car car : this.cars) {
            String name = car.toString();
            Integer position = car.getPosition();

            stateOfCars.put(name, position);
        }

        return stateOfCars;
    }

    public int getMaxPosition() throws NoSuchElementException {
        Car car =  Arrays.stream(this.cars)
                .max(Car::compareTo)
                .orElseThrow(()->new NoSuchElementException("승자가 없습니다."));

        return car.getPosition();
    }

    public List<String> find(int position) {
        return Arrays.stream(this.cars)
                .filter(car -> car.getPosition() == position)
                .map(Car::toString)
                .collect(Collectors.toList());
    }
}
