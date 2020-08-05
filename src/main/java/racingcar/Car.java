package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private static final int THRESHOLD = 4;
    private static final int START_POINT = 1;
    private int position;

    private Car() {
        this.position = START_POINT;
    }

    public void move(int fuel) {
        if (fuel >= THRESHOLD) {
            this.position++;
        }
    }

    private static Car createCar() {
        return new Car();
    }

    public static Car[] createAllCars(int numberOfCars) {
        Car[] cars = new Car[numberOfCars];

        for (int i = 0; i < numberOfCars; ++i) {
            cars[i] = createCar();
        }

        return cars;
    }

    public static List<Integer> getPositions(Car[] cars) {
        List<Integer> positions = new ArrayList<>();

        for (Car car : cars) {
            positions.add(car.position);
        }

        return positions;
    }
}
