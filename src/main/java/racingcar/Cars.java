package racingcar;

import racingcar.common.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final Car[] cars;

    private Cars(int numberOfCars) {
        this.cars = new Car[numberOfCars];

        for (int i = 0; i < numberOfCars; ++i) {
            cars[i] = Car.createCar();
        }
    }

    public static Cars createAllCars(int numberOfCars) {
        return new Cars(numberOfCars);
    }

    public void moveCars() {
        for (Car car : this.cars) {
            int fuel = RandomGenerator.generateRandomInt();

            car.move(fuel);
        }
    }

    public List<Integer> getPositions() {
        List<Integer> positions = new ArrayList<>();

        for (Car car : this.cars) {
            positions.add(car.getPosition());
        }

        return positions;
    }
}
